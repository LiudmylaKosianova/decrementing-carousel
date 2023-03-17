package com.epam.rd.autotasks;
 package classes;

import java.util.ArrayList;

/**
 * Decrementing Carousel is a container, accepting int elements. DecrementingCarousel has a maximum capacity,
 * specified via the constructor.
 * When created, DecrementingCarousel is in accumulating state: you may add elements via the addElement method
 * and can produce a CarouselRun object via the run method.
 * Once the run method is called, DecrementingCarousel is in running state: it refuses adding more elements.
 * <p>
 * The CarouselRun allows to iterate over elements of the carousel decrementing them one by one with the next method.
 * The next returns the value of the current element. Then it decreases the current element by one and switches to the next element.
 * <p>
 * The CarouselRun iterates over elements in the order of their insertion.
 * When an element is decreased to zero, the CarouselRun will skip it in further iterations.
 * When there are no more elements available for decrementing, the CarouselRun returns -1.
 * <p>
 * The CarouselRun also has the isFinished method, which indicates, if the carousel has run out of the elements to decrement.
 * <p>
 * Specification Details
 * DecrementingCarousel has two public methods:
 * <p>
 * boolean addElement(int element) - adds an element. If element is negative or zero, do not add the element.
 * If container is full, do not add the element. If the run method was called to create a CarouselRun, do not add the element.
 * If element is added successfully, return true. Return false otherwise.
 * <p>
 * CarouselRun run() - returns a CarouselRun to iterate over the elements.
 * If the run method has already been called earlier,
 * it must return null: DecrementingCarousel may generate only one CarouselRun object.
 * <p>
 * CarouselRun has two public methods:
 * int next() - returns the current value of the current element, then decreases the current element by one and switches to the next element in insertion order. Skips zero elements. When there is no more elements to decrease, returns -1.
 * boolean isFinished() - when there is no more elements to decrease, returns true. Otherwise, returns false.
 */

public class DecrementingCarousel {
    private int capacity;
    private int[] contain;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        this.contain = new int[capacity];
    }

    /**
     *  boolean addElement(int element) - adds an element.
     *  If element is negative or zero, do not add the element.
     *  If container is full, do not add the element.
     *  If the run method was called to create a CarouselRun, do not add the element.
     *  If element is added successfully, return true. Return false otherwise.
     */
    public boolean addElement(int element) {
        int number = contain.length;

        if (element > 0 && capacity > 0 && isAlreadyRun == false) { //&& run method was not called to create a CarouselRun
            contain[number-capacity] = element;
            capacity--;

            return true;
        } else {
            return false;
        }
    }

    public int getCapacity() {
        return capacity;
    }
    public int[] getContain() {
        return contain;
    }
    public int getElement(int in){
        return contain [in];
    }
    public int getLength(){
        return contain.length;
    }

    /**
     * CarouselRun run() - returns a CarouselRun to iterate over the elements.
     * If the run method has already been called earlier,
     *  it must return null: DecrementingCarousel may generate only one CarouselRun object.
     */

    private boolean isAlreadyRun = false;
    
    public CarouselRun run() {
        //if(the run method has already been called earlier){return null;}
        if (!isAlreadyRun) {
            isAlreadyRun = true;
            return new CarouselRun(contain);
        } else {
            return null;
        }
        
    }    

}

