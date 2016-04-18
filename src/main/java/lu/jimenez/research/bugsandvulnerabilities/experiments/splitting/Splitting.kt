/////////////////////////////////////////////////////////////////////////////////////////
//                 University of Luxembourg  -
//                 Interdisciplinary center for Security and Trust (SnT)
//                 Copyright © 2016 University of Luxembourg, SnT
//
//
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Lesser General Public
//  License as published by the Free Software Foundation; either
//  version 3 of the License, or (at your option) any later version.
//
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Lesser General Public License for more details.
//
//  You should have received a copy of the GNU Lesser General Public
//  License along with this library; if not, write to the Free Software
//  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
//
//
//    Author: Matthieu Jimenez – SnT – matthieu.jimenez@uni.lu
//
//////////////////////////////////////////////////////////////////////////////////////////
package lu.jimenez.research.bugsandvulnerabilities.experiments.splitting

import lu.jimenez.research.bugsandvulnerabilities.experiments.splitting.utils.Constants
import java.util.*


class Splitting {



    companion object run {

        @JvmStatic
        fun main(args: Array<String>) {
            if (args.size > 0 && args.size < 3) {
                val pathOfLoading = args[0]
                val pathOfSaving: String
                if (args.size == 2)
                    pathOfSaving = args[1]
                else pathOfSaving = pathOfLoading

                loadingProperties()
            }
        }
        /**
         * Method for loading properties located in the collector.properties file
         */
        fun loadingProperties() {
            val inputStream = this.javaClass.classLoader.getResourceAsStream("collector.properties")

            val properties = Properties()
            properties.load(inputStream)
            inputStream.close()
            Constants.REALISTIC_GEN = properties.getProperty("realisticgen").toBoolean()
            Constants.EXPERIMENTAL_GEN = properties.getProperty("experimentalgen").toBoolean()
            Constants.TIME_SPLIT = properties.getProperty("timeSplit").split(",").map { time -> time.toInt() }
            Constants.NB_EXPERIMENT_RANDOM_PURE = properties.getProperty("nbRandomPureExperiment").toInt()
            Constants.NB_EXPERIMENT_EQUILIBRATE = properties.getProperty("nbRandomEquilibrateExperiment").toInt()

        }
    }

}