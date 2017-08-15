using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace Assignment2
{
    public delegate void priceCutEventDelegate(int pr);

    /// <summary>
    /// ChickenFarm is a class on the server side: It will be started as a thread by the Main method
    /// and will perform a number of service functions.It uses a PricingModel to determine the chicken prices. 
    /// It defines a price-cut event that can emit an event and call the event handlers in the Retailers 
    /// if there is a price-cut according to the PricingModel. It receives the orders (in string) from the MultiCellBuffer.
    /// It calls the Decoder to convert the string into the order object. 
    /// For each order, it starts a new thread (resulting in multiple threads for processing multiple orders*) 
    /// from OrderProcessing class (or method) to process the order based on the current price. 
    /// There is a counter p (noOfPriceCuts) in the ChickenFarm.After p price cuts have been made, the ChickenFarm thread will terminate.
    /// </summary>
    public class ChickenFarm
    {
        static Random rng = new Random();
        public static event priceCutEventDelegate priceCutEvent;
        private static int chickenPrice = 10;  //base price of chicken
        private static int noOfPriceCuts = 0;  // counter to track number of price cuts

        public int getPrice() { return chickenPrice; }

        /*public static void changePrice(int price)
        {
            if (price < chickenPrice)
            {
                    noOfPriceCuts++;
                    priceCutEvent(price);  
                    chickenPrice = price;
            }       
            //return noOfPriceCuts;
        }*/

        public void farmerFunc()
        {
            while(true)
            {
                Thread.Sleep(500);
                //-----Priccing Model--------
                //create random number generator to fluctuate chicken prices between 5 to 10 bucks
                int currentChickenPrice = rng.Next(5, 10);
                if (currentChickenPrice < chickenPrice)
                {
                    noOfPriceCuts += 1;
                    if (noOfPriceCuts >= 10)
                    {
                        Console.WriteLine("****************Max price cuts limit reached*******************");
                        Console.WriteLine("---------------Processing Existing order only------------------");
                        Console.WriteLine("-------------------Chicken Farm Closed--------------------------");
                        break;
                    }
                    priceCutEvent(currentChickenPrice);    //call event
                }
                chickenPrice = currentChickenPrice;
            }
        }

        /// <summary>
        /// This method represents a every new order received by the chicken farm.
        /// </summary>
        public void newOrder()
        {
            string orderString;
            while(true)
            {
                Thread.Sleep(500);
                orderString = MultiCellBuffer.getOneCell();
                if (orderString != null)
                {
                    OrderProcessing orderprocessor = new OrderProcessing(orderString);
                    Thread orderThread = new Thread(new ThreadStart(orderprocessor.processOrder));
                    orderprocessor.processOrder();
                }
            }
        }
    }
}
