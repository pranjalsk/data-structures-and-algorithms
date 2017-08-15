using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace Assignment2
{
    public class Program
    {
        /// <summary>
        /// Main class invokes all the methods and events
        /// </summary>
        /// <param name="args"></param>
        static void Main(string[] args)
        {
            ChickenFarm chicken = new ChickenFarm();
            MultiCellBuffer multicellbuffer = new MultiCellBuffer();
            Thread farmer = new Thread(new ThreadStart(chicken.farmerFunc));
            farmer.Start();
            Thread newOrders = new Thread(new ThreadStart(chicken.newOrder));
            newOrders.Start();

            Retailer[] chickenStore = new Retailer[5];
            for (int i = 0; i < chickenStore.Length; i++)
            {
                // Retailer IDs of 5 retailers will be "0" to "4"
                chickenStore[i] = new Retailer(i);
                Thread chickenRetailer = new Thread(new ThreadStart(chickenStore[i].retailerFunc));
                ChickenFarm.priceCutEvent += new priceCutEventDelegate(chickenStore[i].chickenOnSale);
                OrderProcessing.confirmOrderEvent += new confirmOrderDelegate(chickenStore[i].confirmOrder);
                //chickenRetailer.Name = (i+1).ToString();
                chickenRetailer.Start();
            }
            Console.ReadLine();
        }
    }
}
