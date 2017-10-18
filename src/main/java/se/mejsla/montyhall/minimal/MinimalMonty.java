/*
 * Copyright (C) 2017 Johan Dykstrom
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package se.mejsla.montyhall.minimal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A minimal simulation of the Monty Hall-problem.
 *
 * @author Johan Dykstrom
 */
public class MinimalMonty {

    public static void main(String[] args) {
        Random random = new Random();
        Integer numberOfIterations = 1000000;
        Integer firstChoiceCounter = 0;
        Integer secondChoiceCounter = 0;
        
        for (int iteration = 0; iteration < numberOfIterations; iteration++) {
            // There are three boxes
            List<Integer> boxes = new ArrayList<>(Arrays.asList(0, 1, 2));
            // One contains money
            Integer moneyBox = random.nextInt(3);
            // Player chooses one
            Integer firstChoice = random.nextInt(3);
            // Monty opens one of the remaining empty boxes (may be one or two)
            boxes.remove(moneyBox);
            boxes.remove(firstChoice);
            Integer openBox = boxes.get(random.nextInt(boxes.size()));
            // Player may choose a new box
            boxes.remove(openBox);
            Integer secondChoice = boxes.isEmpty() ? moneyBox : boxes.get(0);
            
            // Record results
            firstChoiceCounter += firstChoice.equals(moneyBox) ? 1 : 0;
            secondChoiceCounter += secondChoice.equals(moneyBox) ? 1 : 0;
        }
        
        // Print results
        System.out.printf("First choice correct:  %2.2f%%%n", (100.0 * firstChoiceCounter) / numberOfIterations);
        System.out.printf("Second choice correct: %2.2f%%%n", (100.0 * secondChoiceCounter) / numberOfIterations);
        System.out.printf("Number of iterations: %d%n", numberOfIterations);
    }
}
