using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace Assignment2
{
    /// <summary>
    /// OrderClass is a class that contains at least the following private data members:
    /// senderId: the identity of the sender, you can use thread name or thread id;
    /// cardNo: an integer that represents a credit card number;
    /// amount: an integer that represents the number of chickens to order;
    /// You must use public methods to set and get the private data members. 
    /// You must decide if these methods need to be synchronized. The instances created from this class
    /// are of the OrderObject
    /// </summary>
    public class Order
    {
        private int senderId;  // Id of the retailer
        private int cardNo;   // Credit card number
        private int amount;    // numberof chickens in the order
        private int price;      // price of the chicken for the order

        static readonly object _locker = new object();

        public Order() { }

        public Order(int senderId, int cardNo, int amount, int price)
        {
            this.senderId = senderId;
            this.cardNo = cardNo;
            this.amount = amount;
            this.price = price;
        }

        // Getter and setter for Sender's ID attribute
        public int getSenderId()
        {
            return this.senderId;
        }

        public void setSenderId(int senderId)
        {
            Monitor.Enter(_locker);
            try
            {
                this.senderId = senderId;
            }
            finally
            {
                Monitor.Exit(_locker);
            }
        }

        // Getter and setter for credit card number attribute
        public int getCardNo()
        {
            return this.cardNo;
        }

        public void setCardNo(int cardNo)
        {
            Monitor.Enter(_locker);
            try
            {
                this.cardNo = cardNo;
            }
            finally
            {
                Monitor.Exit(_locker);
            }
        }

        // Getter and setter for Amount of chickens attribute
        public int getAmount()
        {
            return this.amount;
        }

        public void setAmount(int amount)
        {
            Monitor.Enter(_locker);
            try
            {
                this.amount = amount;
            }
            finally
            {
                Monitor.Exit(_locker);
            }
        }

        // Getter and setter for Price attribute
        public int getPrice()
        {
            return this.price;
        }

        public void setPrice(int price)
        {
            Monitor.Enter(_locker);
            try
            {
                this.price = price;
            }
            finally
            {
                Monitor.Exit(_locker);
            }
        }
    }
}
