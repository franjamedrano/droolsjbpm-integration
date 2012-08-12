package org.jbpm.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.eclipse.bpmn2.FlowElement;
import org.eclipse.bpmn2.SequenceFlow;

public class PathContext {
    
    public enum Type {
        ROOT,
        ACTIVE,
        COMPLETED,
        TEMP;
    }

    private List<FlowElement> pathElements = new ArrayList<FlowElement>();
    private Type type;
    private boolean canBeFinished = true;
    private boolean locked = false;
    private String id; 
    private int canBeFinishedCounter = 0;
    
    protected int getCanBeFinishedCounter() {
        return canBeFinishedCounter;
    }

    protected void setCanBeFinishedCounter(int canBeFinishedCounter) {
        this.canBeFinishedCounter = canBeFinishedCounter;
    }

    public PathContext() {
    	this.id = String.valueOf(UUID.randomUUID());
    	this.setType(Type.ROOT);
    }
    
    public PathContext(Type type) {
    	this.id = String.valueOf(UUID.randomUUID());
        this.setType(type);
    }
    
    public void addPathElement(FlowElement element) {
        if (!locked) {
            this.pathElements.add(element);
        }
    }
    
    public void addAllPathElement(List<SequenceFlow> elements) {
        if (!locked) {
            this.pathElements.addAll(elements);
        }
    }
    
    public List<FlowElement> getPathElements() {
        return this.pathElements;
    }

    public void setPathElements(List<FlowElement> pathElements) {
        this.pathElements = pathElements;
    }

    public boolean isCanBeFinished() {
        return canBeFinished;
    }
    
    public void setCanBeFinishedNoIncrement(boolean canBeFinished) {
        this.canBeFinished = canBeFinished;
    }

    public void setCanBeFinished(boolean canBeFinished) {
        if (canBeFinished) {
            
            if (canBeFinishedCounter == 1) {
                this.canBeFinished = true;
            }
            canBeFinishedCounter--;
        } else {

            if (canBeFinishedCounter == 0) {
                this.canBeFinished = false;
            } 
            canBeFinishedCounter++;
            
        }
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    
    public String getId() {
    	return this.id;
    }
}
