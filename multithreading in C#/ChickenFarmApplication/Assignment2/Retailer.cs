using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace Assignment2
{
    /// <summary>
    /// Retailer1 through RetailerN, where N = 5, each retailer is a thread instantiated from 
    /// the same class (or the same method) in a class. The retailers’ actions are event-driven. 
    /// Each retailer contains a callback method (event handler) for the ChickenFarm to call
    /// when a price-cut event occurs. The retailer will calculate the number of chickens to order,
    /// for example, based on the need and the difference between the previous price and the current price. 
    /// The thread will terminate after the ChickenFarm thread has terminated. Each order is an OrderClass object.
    /// The object is sent to the Encoder for encoding. The encoded string is sent back to the retailer.
    /// Then, the retailer will send the order in String format to the MultiCellBuffer. 
    /// Before sending the order to the MultiCellBuffer, a time stamp must be saved. 
    /// When the confirmation of order completion is received, the time of the order will be calculated and 
    /// saved (or printed).
    /// </summary>
    public class Retailer
    {
        public static Boolean flag;
        public static DateTime startTime;
        public int retailerid;

        public Retailer() { }
        public Retailer(int retailerid)
        {
            this.retailerid = retailerid;
            flag = true; //order completion flag
        }

        public void retailerFunc()
        {
            ChickenFarm chicken = new ChickenFarm();
            while (true)
            {
                Thread.Sleep(1000);
                int chickenPrice = chicken.getPrice();
                //Console.WriteLine("Retailer {0} has everyday low price: ${1} each", id, p);
            }
        }

        public void chickenOnSale(int chickenPrice)
        {
            Console.WriteLine("Chickens are on sale as low as ${0} each", chickenPrice);
            //Generate random credit card numbers between 5000 to 7000
            Random rdm1 = new Random();
            int cardNo = rdm1.Next(5000, 7000);

            //Generate random no. of units chicken from retailer
            Random rdm2 = new Random();
            int amount = rdm2.Next(1, 20);
            Console.WriteLine("Retailer {0} has ordered {1} chickens", retailerid, amount);

            Order order = new Order(retailerid, cardNo, amount, chickenPrice);

            //record the start time
            startTime = DateTime.Now;
            //create a new thread for each order
            Console.WriteLine("New chicken order sent by Retailer {0}", retailerid);

            // New  order sent to chicken farm
            Thread newOrder = new Thread(new ParameterizedThreadStart(MultiCellBuffer.setOneCell));
            newOrder.Start(CryptoClass.Encoder(order));
        }

        /// <summary>
        /// A method used by the event to confirm the order.
        /// </summary>
        /// <param name="order"></param>
        public void confirmOrder(Order order)
        {
            if (flag)
            {
                Console.WriteLine("Transaction successful for Retailer {0} in time {1}", order.getSenderId(), DateTime.Now - startTime);
                flag = false;
            }
        }
    }
}
