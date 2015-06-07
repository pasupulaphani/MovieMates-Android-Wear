package net.appmecha.comcast.wear.moviemates;

import java.util.Random;

/**
 * Created by Neil on 07/06/2015.
 */
public class Utils{

        /**
         * Returns a psuedo-random number between min and max, inclusive.
         * The difference between min and max can be at most
         * <code>Integer.MAX_VALUE - 1</code>.
         *
         * @param min Minimim value
         * @param max Maximim value.  Must be greater than min.
         * @return Integer between min and max, inclusive.
         * @see java.util.Random#nextInt(int)
         */
        public static int randInt(int min, int max) {

            // Usually this can be a field rather than a method variable
            Random rand = new Random();

            // nextInt is normally exclusive of the top value,
            // so add 1 to make it inclusive
            int randomNum = rand.nextInt((max - min) + 1) + min;

            return randomNum;
        }
}
