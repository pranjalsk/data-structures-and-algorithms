using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace Assignment2
{
    /// <summary>
    /// Represent structure of each buufercell in the MultiCellBuffer
    /// </summary>
    public class BufferCell
    {
        public string cellValue;
        public Boolean writeable;
        public BufferCell()
        {
            cellValue = null;
            writeable = false;
        }
    }

    /// <summary>
    /// MultiCellBuffer class is used for sending the order from the retailers (clients) to the chickenFarm (server).
    /// This class has n data cells (you can simply set n = 2). The number of cells is less than the max number N 
    /// (you can set N = 5 or enter N from keyboard) of retailers in your experiment.You must use a semaphore
    /// of value n to manage the cells and use a lock for each cell to ensure the synchronization
    /// </summary>
    public class MultiCellBuffer
    {
        private static readonly object _locker = new object();
        public static BufferCell[] bufferArray = new BufferCell[3];
        private static int BufferCapacity = 0;
        private static int index = 0;
        private static Semaphore emptyBufferArray = new Semaphore(3, 3);
        private static Semaphore fullBufferArray = new Semaphore(0, 3);
      
        public MultiCellBuffer()
        {
            //initialize alll buffercell objects
            for (int i = 0; i < bufferArray.Length; i++)
            {
                bufferArray[i] = new BufferCell();
            }
        }

        /// <summary>
        /// getOneCell methods defined to read data from one of the available cells.
        /// </summary>
        /// <returns></returns>
        public static string getOneCell()
        {
            string cellvalue;
            fullBufferArray.WaitOne();  
            Monitor.Enter(_locker);
            try
            {        
                BufferCapacity--;
                // Console.WriteLine(BufferCapacity);
                index--;
                bufferArray[index].writeable = true;
                cellvalue = bufferArray[index].cellValue;
                bufferArray[index].writeable = false;
            }
            finally
            {
                Monitor.Exit(_locker);
            }
            emptyBufferArray.Release();
            return cellvalue;
        }


        /// <summary>
        /// getOneCell methods can be defined to write data into one of the available cells.
        /// </summary>
        /// <param name="cellValue"></param>
        public static void setOneCell(Object cellValue)
        {
            string cellvalue = cellValue.ToString();
            emptyBufferArray.WaitOne();
            Monitor.Enter(_locker);
            try
            {
                bufferArray[index].writeable = true;
                bufferArray[index].cellValue = cellvalue;
                BufferCapacity++;
               // Console.WriteLine(BufferCapacity);
                bufferArray[index].writeable = false;
                index++;
            }
            finally
            {
                Monitor.Exit(_locker);
            }
            fullBufferArray.Release();
        }
    }
}
