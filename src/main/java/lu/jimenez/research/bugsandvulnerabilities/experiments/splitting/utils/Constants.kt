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
package lu.jimenez.research.bugsandvulnerabilities.experiments.splitting.utils


/**
 * Variable initialized through the splitting properties files
 *
 * Experimental Gen : Experimental Dataset?
 * Realistic Gen : Realistic dataset
 * TIME split: list of point in times where we want to split data in two
 * NB_EXPERIMENT_RANDOM_PURE how many time should we do the random pure experiment
 * NB_EXPERIMENT_EQUILIBRATE how many time should we do the random equilibrate experiment
 * Random : generate random experiments
 * Time: generate time experiment
 */
object Constants {
    var EXPERIMENTAL_GEN: Boolean=false
    var REALISTIC_GEN: Boolean=false
    var TIME_SPLIT: List<Int> = listOf()
    var NB_EXPERIMENT_RANDOM_PURE: Int = 1
    var NB_EXPERIMENT_EQUILIBRATE: Int = 1
    var RANDOM = false
    var TIME = false
}