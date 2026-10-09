package dataStructures;

import dataStructures.exceptions.NoSuchElementException;

/**
 * Implementation of an Iterator for Linked List
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */

class LinkedIterator<E>  implements Iterator<E> {
    /**
     * First node of the list.
     */
    private final LinkedNode<E> first;
    /**
     * Node with the next element in the iteration.
     */
    LinkedNode<E> nextToReturn;

    /**
     * SinglyIterator constructor
     * @param first - Node with the first element of the iteration
     */
    public LinkedIterator(LinkedNode<E> first) {
        this.first=first;
        nextToReturn=first;
    }
    public E next(){
        if(!this.hasNext())
            throw new NoSuchElementException();
        //TO DO
    }
    //TODO: Left as an exercise.
    public void rewind(){

    }
}
