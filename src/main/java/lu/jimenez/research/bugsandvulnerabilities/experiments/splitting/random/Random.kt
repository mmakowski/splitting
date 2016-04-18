package lu.jimenez.research.bugsandvulnerabilities.experiments.splitting.random

import lu.jimenez.research.bugsandvulnerabilities.experiments.splitting.utils.Constants
import lu.jimenez.research.bugsandvulnerabilities.model.extension.experiment.ExperimentalSets
import lu.jimenez.research.bugsandvulnerabilities.model.internal.DocumentType
import java.util.*


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

class Random (val listOfInterestingID: List<Int>){

    /**
     *Method to generate a number of experiments without taking in consideration the class of the elements
     * each experiments test and training set will have the same size.
     *
     * @return map of all experiments
     */
    fun pureRandom(): Map<String, ExperimentalSets> {
        val mapExperiment = mutableMapOf<String, ExperimentalSets>()
        for (i in 0..(Constants.NB_EXPERIMENT_RANDOM_PURE- 1)) {
            Collections.shuffle(listOfInterestingID)
            val testingset = mutableListOf<Int>()
            val trainingset = mutableListOf<Int>()
            var testing = false
            for (id in listOfInterestingID) {
                if (testing) testingset.add(id)
                else trainingset.add(id)
                testing = !testing
            }
            mapExperiment.put("Pure${i+1}", ExperimentalSets(trainingset, testingset))
        }
        return mapExperiment
    }

    /**
     * Method to generate a number of experiments keeping the same proportion of file in their training and testing sets
     */
    fun equilibrateRandom(mapofIDType: Map<Int, DocumentType>): Map<String, ExperimentalSets> {
        val mapExperiment = mutableMapOf<String, ExperimentalSets>()
        for (j in 0..(Constants.NB_EXPERIMENT_EQUILIBRATE - 1)) {
            Collections.shuffle(listOfInterestingID)
            val testingset = mutableListOf<Int>()
            val trainingset = mutableListOf<Int>()
            val testing = mutableListOf(false, false, false, false, false)
            var i = 0
            for (id in listOfInterestingID) {
                when (mapofIDType[id]) {
                    DocumentType.BUGGY_FILE -> i = 0
                    DocumentType.PATCHED_BUGGY_FILE -> i = 1
                    DocumentType.VULNERABLE_FILE -> i = 2
                    DocumentType.PATCHED_VULNERABLE_FILE -> i = 3
                    DocumentType.CLEAR_FILE -> i = 4
                }
                if (testing[i]) testingset.add(id)
                else trainingset.add(id)
                testing[i] = !testing[i]
            }
            mapExperiment.put("Equilibrate${j+1}", ExperimentalSets(trainingset,testingset))
        }
        return mapExperiment
    }
}