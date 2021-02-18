package DecisionFiles;

public class DecisionNode {

    int nodeID;
    int aID;
    int bID;
    int cID;

    String description;
    String question;
    String imgPath;

    String choiceA;
    String choiceB;
    String choiceC;

    DecisionNode aNode;
    DecisionNode bNode;
    DecisionNode cNode;

    DecisionNode linkedNode;

    public DecisionNode() {
    }

    public DecisionNode getLinkedNode() {
        return linkedNode;
    }

    public void setLinkedNode(DecisionNode linkedNode) {
        this.linkedNode = linkedNode;
    }

    /***********************/
    public String getChoiceA() {
        return choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceA(String choiceA) throws IncompleteCsvException{
        if (choiceA == null){
            throw new IncompleteCsvException("The text for Choice A at NodeID " + getNodeID() + " is null.");
        }
        this.choiceA = choiceA;
    }

    public void setChoiceB(String choiceB) throws IncompleteCsvException{
        if (choiceB == null){
            throw new IncompleteCsvException("The text for Choice B at NodeID " + getNodeID() + " is null.");
        }
        this.choiceB = choiceB;
    }
    public void setChoiceC(String choiceC) throws IncompleteCsvException{
        if (choiceC == null){
            throw new IncompleteCsvException("The text for Choice C at NodeID " + getNodeID() + " is null.");
        }
        this.choiceC = choiceC;
    }


    public int getNodeID() {
        return nodeID;
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }

    public int getaID() {
        return aID;
    }

    public void setaID(int aID) {
        this.aID = aID;
    }

    public int getbID() {
        return bID;
    }

    public void setbID(int bID) {
        this.bID = bID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public int getcID() {
        return cID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws IncompleteCsvException {
        if (description == null) {
            throw new IncompleteCsvException("Description at NodeID " + getNodeID() + " is null.");
        } else {
            this.description = description;
        }
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) throws IncompleteCsvException {
        if (question == null) {
            throw new IncompleteCsvException("Question at NodeID " + getNodeID() + " is null.");
        } else {
            this.question = question;
        }
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) throws IncompleteCsvException {
        if (imgPath == null) {
            throw new IncompleteCsvException("Image path at Node ID " + getNodeID() + " is null.");
        } else {
            this.imgPath = imgPath;
        }
    }

    public DecisionNode getaNode() {
        return aNode;
    }

    public void setaNode(DecisionNode aNode) throws IncompleteCsvException {
        if (aNode == null) {
            throw new IncompleteCsvException("Node A at Node ID " + getNodeID() + " is null.");
        } else {
            this.aNode = aNode;
        }
    }

    public DecisionNode getbNode() {
        return bNode;
    }

    public void setbNode(DecisionNode bNode) throws IncompleteCsvException {
        if (bNode == null) {
            throw new IncompleteCsvException("Node B at Node ID " + getNodeID() + " is null.");
        } else {
            this.bNode = bNode;
        }
    }

    public DecisionNode getcNode() {
        return cNode;
    }

    public void setcNode(DecisionNode cNode) throws IncompleteCsvException {
        if (cNode == null) {
            throw new IncompleteCsvException("Node C at Node ID " + getNodeID() + " is null.");
        } else {
            this.cNode = cNode;
        }
    }
}





