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
package lu.jimenez.research.bugsandvulnerabilities.experiments.splitting.kfoldxvalidation

import lu.jimenez.research.bugsandvulnerabilities.model.internal.DocumentType



object KFold {
    /**
     * Method to generate the set of files for a Kfold experiments on vulnerability Buggy and clear (all patch are removed)
     *
     * @param mapIDType map generated by the collector module
     *
     * @return list of the hash of the document
     */
    fun computeKfoldVulnBugClear(mapIDType : Map<Int,DocumentType>) : List<Int>{
        return mapIDType.filterValues { type ->
            (type == DocumentType.BUGGY_FILE ||
                    type == DocumentType.CLEAR_FILE ||
                    type == DocumentType.VULNERABLE_FILE)
        }.keys.toList()

    }
}