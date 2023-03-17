package com.epam.rd.autotasks;




/**
 *  The CarouselRun iterates over elements in the order of their insertion.
 *  When an element is decreased to zero, the CarouselRun will skip it in further iterations.
 *  When there are no more elements available for decrementing, the CarouselRun returns -1.
 * CarouselRun has two public methods:
 * <p>
 * int next() - returns the current value of the current element, then decreases the current element by one
 * and switches to the next element in insertion order. Skips zero elements.
 * When there is no more elements to decrease, returns -1.
 * <p>
 * boolean isFinished() - when there is no more elements to decrease, returns true. Otherwise, returns false.
 */
public class CarouselRun {

    int currentPosition = 0;
    int [] containRunning;
    public CarouselRun(int[]greenSofa) {
        this.containRunning = greenSofa;
    }

    /**
     * I need this method, because I need to check
     * if all the numbers in the "containRunning" are zeros or not
     * @return true, if all the elements in the "containRunning" are zeros
     */
    public boolean onlyZeros (){
        for(int element: containRunning){
            if(element!=0){
               return false;}
        }

        return true;
    }

    /**
     * int next() - returns the current value of the current element,
     * then decreases the current element by one
     * and switches to the next element in insertion order. Skips zero elements.
     * When there is no more elements to decrease, returns -1.
     */
    public int next(){

        if(onlyZeros()){
            return -1;
        }
        //the value of the current element can't be zero, since we should skip zero elements
        // Let's find the currentPosition, that points to not a zero element

        while(containRunning[currentPosition]==0){
            currentPosition++;
            if(currentPosition==containRunning.length){
                currentPosition=0;
            }
        }

        int willReturn = containRunning[currentPosition];//I'm so happy it is not zero )))
        containRunning[currentPosition]--;
        currentPosition++;
        //make sure that currentPosition is not bigger, than the length of containRunning
        //if it is bigger, that I need to start from the beginning
        if(currentPosition==containRunning.length){
            currentPosition=0;
        }
        return willReturn;
    }

        //Ferrari's ideas:
// currentPosition++;
// return this.getContain()[currentPosition];



    public boolean isFinished(){
        return onlyZeros();
    }
}
 

