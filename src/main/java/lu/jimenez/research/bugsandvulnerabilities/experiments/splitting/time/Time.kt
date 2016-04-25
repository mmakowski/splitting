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
package lu.jimenez.research.bugsandvulnerabilities.experiments.splitting.time

import lu.jimenez.research.bugsandvulnerabilities.experiments.splitting.utils.Constants
import lu.jimenez.research.bugsandvulnerabilities.model.extension.experiment.ExperimentalSets
import lu.jimenez.research.bugsandvulnerabilities.model.internal.Document



object Time {
    /**
     * Splitting dataset in experiments according to time split
     */
    fun splitting(listOfInterstingId : List<Int>,mapOfIdDoc : Map<Int, Document>):Map<String,ExperimentalSets>{
        val mapExperiment = mutableMapOf<String, ExperimentalSets>()
        for (date in Constants.TIME_SPLIT) {
            val testingset = mutableListOf<Int>()
            val trainingset = mutableListOf<Int>()
            for (i in listOfInterstingId){
                if (mapOfIdDoc[i]!!.time>date) testingset.add(i)
                else trainingset.add(i)
            }
            mapExperiment.put("Time_$date", ExperimentalSets(trainingset,testingset))
        }
        return mapExperiment
    }
}