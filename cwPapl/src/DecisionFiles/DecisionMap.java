package DecisionFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.*;

public class DecisionMap {

    DecisionNode head;
    DecisionNode tail;
    DecisionNode currentNode;


    public DecisionMap() throws FileNotFoundException {

        Scanner inFile = connectDataSet("src/DecisionFiles/cwPapl.csv");

        try {
            buildUnorderedList(inFile);
            buildOrderedMap();
        } catch (IncompleteCsvException iCE){
            iCE.getMessage();
        }
        currentNode = head;

    }

    public ArrayList<String> getChoices(){

        ArrayList<String> choices = new ArrayList<>();

        choices.add(currentNode.getChoiceA().toUpperCase());
        choices.add(currentNode.getChoiceB().toUpperCase());

        String choiceC = currentNode.getChoiceC().toUpperCase();

        if(!choiceC.equals("-")){
            choices.add(choiceC);
        }

        return choices;
    }

    public void setChoices(String choice) throws InvalidChoiceException{
        if (choice.equals("A")){
            currentNode = currentNode.getaNode();
        }else if (choice.equals("B")){
            currentNode = currentNode.getbNode();
        }else if (choice.equals("C")){
            currentNode = currentNode.getcNode();
        }else{
            throw new InvalidChoiceException("Choice " + choice + " is not valid. ");
        }
    }



    public String getDesc(){
        return currentNode.getDescription();
    }

    public String getQues(){
        return currentNode.getQuestion();
    }

    public String getimgPath() {return currentNode.getImgPath();}


    private void append(DecisionNode newNode) {

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.setLinkedNode(null);

            return;
        }

        this.tail.setLinkedNode(newNode);
        this.tail = newNode;
    }


    public Scanner connectDataSet(String pathName) throws FileNotFoundException {

        File prc = new File(pathName);
        return new Scanner(prc);
    }

    public void buildUnorderedList(Scanner dataSet) throws IncompleteCsvException{               //extracting data from the csv file line by line
        dataSet.useDelimiter(",");                                                               //appending it
        DecisionNode node;
        do {
            String line = dataSet.nextLine();
            node = buildNode(line);
            append(node);
        } while (dataSet.hasNext());
        dataSet.close();

    }

    private void buildOrderedMap() throws IncompleteCsvException {                                //assigning the extracted data, assigning set a/b/c nodes

        if (head == null) {
            return; }

        DecisionNode nodeLinker = head;

        while (nodeLinker != null) {

            int aID = nodeLinker.getaID();
            int bID = nodeLinker.getbID();
            int cID = nodeLinker.getcID();


            DecisionNode aNode = nodeFetch(aID);
            DecisionNode bNode = nodeFetch(bID);
            DecisionNode cNode = nodeFetch(cID);


            nodeLinker.setaNode(aNode);
            nodeLinker.setbNode(bNode);
            nodeLinker.setcNode(cNode);

            nodeLinker = nodeLinker.getLinkedNode();

        }

        cleanup();

    }


    private void cleanup() {                             //breaks the linkage between current and next and move the current and next 4ward
        if (head == null) {
            return;
        }
        DecisionNode currentNode = head;
        DecisionNode nextNode = head.getLinkedNode();

        while (nextNode != null) {

            currentNode.setLinkedNode(null);

            currentNode = nextNode;
            nextNode = currentNode.getLinkedNode();
        }
    }

    private DecisionNode buildNode(String line) throws IncompleteCsvException{
        String[] stringArray = line.split(",",-1);
        DecisionNode n = new DecisionNode();

        try {
            n.setNodeID(valueOf(stringArray[0]));
            n.setaID(valueOf(stringArray[1]));
            n.setbID(valueOf(stringArray[2]));
            n.setcID(valueOf(stringArray[3]));

            n.setDescription(stringArray[4]);
            n.setQuestion(stringArray[5]);

            n.setChoiceA(stringArray[6]);
            n.setChoiceB(stringArray[7]);
            n.setChoiceC(stringArray[8]);

            n.setImgPath(stringArray[9]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("The specified index within the csv file does not exist in the array.");
        }

        return n;
    }

    public DecisionNode entryPoint() {
        return head;
    }

    private DecisionNode nodeFetch(int nodeID) {

        DecisionNode nodeLinker = head;

        while (nodeLinker != null) {
            if (nodeLinker.getNodeID() == nodeID) {
                break;
            }
            nodeLinker = nodeLinker.getLinkedNode();
        }

        return nodeLinker;
    }


    private boolean isEmpty() {
        return this.head == null;
    }

}

