using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace Assignment2
{
    public delegate void confirmOrderDelegate(Order order);

    /// <summary>
    /// OrderProcessing is a class or a method in a class on server side.
    /// Whenever an order needs to be processed, a new thread is instantiated from this class (or method)
    /// to process the order. It will check the validity of the credit card number. 
    /// You can define your own credit card format, for example, the credit card number 
    /// from the retailers must be a number registered to the ChickenFarm, or a number between two given numbers
    /// (e.g., between 5000 and 7000). Each OrderProcessing thread will calculate the total amount of charge,
    /// e.g., unitPrice*NoOfChickens + Tax + shippingHandling. It will send a confirmation to the retailer 
    /// when an order is completed. The confirmation must be implemented using a callback method
    /// </summary>
    public class OrderProcessing
    {
        static readonly object _locker = new object();
        public static event confirmOrderDelegate confirmOrderEvent;
        string encodedOrder;

        public OrderProcessing() { }
        public OrderProcessing(string encodedOrder) {
            this.encodedOrder = encodedOrder;
        }

        /// <summary>
        /// This is callback method calculates total amount the retailer has to pay for the order
        /// </summary>
        public void processOrder() {
            Order order = CryptoClass.Decoder(encodedOrder); //decrypt the encoded order string
           // Console.WriteLine("---Retailer {0} has placed an order---",order.getSenderId());

            double tax = 1.08;          // 8% tax
            double shipping = 3.0;      // shipping an dhandling charges
            double totalAmount = (order.getAmount()*order.getPrice() + shipping) * tax;

            int cardNo = order.getCardNo();
            //credit numbers between 5000 and 7000 has valid accounts under chicken farm       
            Monitor.Enter(_locker);
            try
            {
                if (cardNo >= 5000 && cardNo <= 7000)
                {
                    Retailer.flag = true;
                    Console.WriteLine("Order Placed >>> Bill for retailer {0} is ${1}", order.getSenderId(), totalAmount);
                    confirmOrderEvent(order);
                }
                else
                {
                    Console.WriteLine("Transaction Failed >>> Retailer {0} has provided wrong card number--", order.getSenderId());
                }
            }
            finally
            {
                Monitor.Exit(_locker);
            }
        }
    }
}
