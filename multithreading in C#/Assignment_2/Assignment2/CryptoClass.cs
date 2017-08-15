using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment2
{
    public class CryptoClass
    {
        /// <summary>
        /// Encoder is a class or a method in a class: The Encoder class will convert an OrderObject into a string.
        /// You can choose any way to encode the values into a string, as long as you can decode the string to the 
        /// original order object. You can use a class or a method to implement the Encoder.
        /// </summary>
        /// <param name="order"></param>
        /// <returns></returns>
        public static string Encoder(Order order)
        {
            string encodedString = Convert.ToString(order.getSenderId()) + ";" + Convert.ToString(order.getCardNo()) + ";" + Convert.ToString(order.getAmount()) + ";" + Convert.ToString(order.getPrice());
            return encodedString;
        }

        /// <summary>
        /// Decoder is a class or a method in a class: The Decoder will convert the string back into the OrderObject.
        /// </summary>
        /// <param name="encodedString"></param>
        /// <returns></returns>
        public static Order Decoder(Object encodedString)
        {
            string[] tockens = encodedString.ToString().Split(new[] { ";" }, StringSplitOptions.None);
            Order order = new Order(Convert.ToInt32(tockens[0]), Convert.ToInt32(tockens[1]), Convert.ToInt32(tockens[2]), Convert.ToInt32(tockens[3]));
            return order;
        }
    }
}
