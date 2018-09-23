/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdungeon.apps.mindskew;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author NanoDano <nanodano@devdungeon.com>
 */
public class RandomGeneratorManager extends Thread {
    
    int randomNumber;
    int totals[] = new int[10];
    Random randGenerator = new Random();
    int numGenerations = 1000000000;
    private boolean paused = false;
    private boolean started = false;
    
    public RandomGeneratorManager() {
        
    }
    
    public void run() {
        System.out.println("Starting random number generator thread.");
        System.out.println("Generating " + numGenerations + " random numbers. Focus on a single number 0-9.");
                for (int k = 0; k < numGenerations; k++) {
            randomNumber = randGenerator.nextInt(10) + 0;
            totals[randomNumber]++;
        }
        System.out.println("Finished generating random numbers.");
    }
    
    public void togglePause() {
        if (!started) {
            start();
            started = true;
            return;
        }
        
        if (paused) {
            unpause();
        } else {
            pause();
        }
    }
    
    private void pause() {
        System.out.println("Pausing random generator.");
        paused = true;
        suspend();
    }
    
    private void unpause() {
        System.out.println("Unpausing random generator.");
        resume();
        paused = false;
    }
    
    public static void main(String[] args) {
        RandomGeneratorManager rg = new RandomGeneratorManager();
        rg.start();
           
        
    }

}
