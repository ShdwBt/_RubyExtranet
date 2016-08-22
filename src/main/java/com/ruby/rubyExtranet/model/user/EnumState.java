package com.ruby.rubyExtranet.model.user;

public enum EnumState {
	
	ACTIVE("ACTIVE"),
	INACTIVE("INACTIVE"),
	DELETED("DELETED"),
	LOCKED("LOCKED");
     
    private String state;
     
    private EnumState(final String state){
        this.state = state;
    }
     
    public String getState(){
        return this.state;
    }
 
//    @Override
//    public String toString(){
//        return this.state;
//    }
	 
}
