package com.projects.igritdatacollector.exception;


public class ListingNotFoundException extends RuntimeException{

    public ListingNotFoundException(Long id){
        super("Listing not found with id: " + id);
    }

    public ListingNotFoundException(String message){
        super(message);
    }


}
