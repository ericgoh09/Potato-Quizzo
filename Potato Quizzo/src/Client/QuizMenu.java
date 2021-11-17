/*
	Name:		Koh Xin Hao
	StudID:		20WMR09471
	Group:		RSF2 G4
	Project:	QuizMenu.java
*/
package Client;

import Entity.Question;
import Entity.ReadWriteFile;
import Client.*;
import Superclass.*;
import Interface.*;
import ADT.*;

import java.util.*;

public class QuizMenu extends CircularLinkedList{
    
    // Variable declaration
    private static CircularLinkedListInterface<Question> animalList = new CircularLinkedList<>();
    private CircularLinkedListInterface<Question> countryList = new CircularLinkedList<>();
    private CircularLinkedListInterface<Question> plantList = new CircularLinkedList<>();
    private int animalQuizQuestionNo;
    private int countryQuizQuestionNo;
    private int plantQuizQuestionNo;
    
    // Method to run quiz
    public QuizMenu playQuiz(int animalQuizQuestionNo, int countryQuizQuestionNo, int plantQuizQuestionNo){
        
        writePlant();
        writeAnimal();
        writeCountry();
        
        QuizMenu quizMenu = new QuizMenu(animalQuizQuestionNo, countryQuizQuestionNo, plantQuizQuestionNo);

        quizMenu.menu();
        
        QuizMenu temp = new QuizMenu();
        
        temp.setAnimalQuizQuestonNo(quizMenu.getAnimalQuizQuestonNo());
        temp.setCountryQuizQuestonNo(quizMenu.getCountryQuizQuestonNo());
        
        temp.setPlantQuizQuestonNo(quizMenu.getPlantQuizQuestonNo());
        
        
        return temp;
    }
    
    public static void writePlant(){
        
        
        Question[] question = new Question[100];
        
        question[0] = new Question("Plant", "> Red color. \n> Flower are large. \n> With five or more petals. \n> Malaysia's national flower.\n ", "Hibiscus", 1);
        question[1] = new Question("Plant", "> Succulents. \n> Fleshy part adapted to store water. \n> No leaves. \n> Suitable live in desert.\n ", "Catus", 2);
        question[2] = new Question("Plant", "> Soft petals. \n> Red color. \n> Stems are loaded with thorns. \n> First choice gift during valentine's day.\n ", "Rose", 3);
        question[3] = new Question("Plant", "> Yellow color. \n> The seed of flower can made guachi for food. \n> The petal will move by following the orientation of the sunlight. \n", "Sunflower", 4);
        question[4] = new Question("Plant", "> There have long and straight green color stem. \n> Used to made the furniture in japan. \n> Favourite food for panda.\n ", "Bamboo", 5);
        
        ReadWriteFile readWriteFile = new ReadWriteFile();
        
        readWriteFile.write(question, "Plant.bin");
    }
    
    public static void writeCountry(){
        
        
        Question[] question = new Question[100];
        
        question[0] = new Question("Country", "> There has three main races in the country. \n> Hibiscus is the national flower. \n> The representative food is nasi lemak. \n", "Malaysia", 1);
        question[1] = new Question("Country", "> Eiffel tower is the landmark of the city. \n> Located in French. \n> Known as romantic city and heaven for honeymoon. \n", "Paris", 2);
        question[2] = new Question("Country", "> Have four season. \n> Sakura(cherry blossom) is national flower for the country. \n> The representative food is sushi. \n", "Japan", 3);
        question[3] = new Question("Country", "> Great wall is the landmark for the country. \n> Plum blossom is national flower for the country. \n> Beijing roast duck is the famous local food. \n", "China", 4);
        question[4] = new Question("Country", "> Taipei 101 is the landamrk of the country. \n> Night market become one of the famous destination in the country. \n> Stinky tofu is the famous food for the local citizen but some of the tourist cannot accept the smelly taste. \n", "Taiwan", 5);
        
        ReadWriteFile readWriteFile = new ReadWriteFile();
        
        readWriteFile.write(question, "Country.bin");
    }
    
    public static void writeAnimal(){
        
        
        Question[] question = new Question[100];
        
        question[0] = new Question("Animal", "> Always stay in front the door. \n> Barking when stranger passing by. \n> Loyal family pet. \n> Intelligent.\n ", "Dog", 1);
        question[1] = new Question("Animal", "> A pair of long ears. \n> Red color eyes. \n> White fur. \n> Love to eat carrot.\n ", "Rabbit", 2);
        question[2] = new Question("Animal", "> Have a long tail. \n> Butt is red. \n> Love to climb the tree. \n> Love to eat banana.\n ", "Monkey", 3);
        question[3] = new Question("Animal", "> Sideways walking. \n> Land and water breathing. \n> A single pair of claws. \n> Having eight leg.\n ", "Crab", 4);
        question[4] = new Question("Animal", "> An animal without a backbone, brain, heart or eyes. \n> They are made up of a smooth. \n> Bag-like body and tentacles armed with tiny.\n> Stinging cells.\n", "jellyfish", 5);
        
        ReadWriteFile readWriteFile = new ReadWriteFile();
        
        readWriteFile.write(question, "Animal.bin");
    }

    public QuizMenu(int animalQuizQuestionNo, int countryQuizQuestionNo, int plantQuizQuestionNo) {
        this.animalQuizQuestionNo = animalQuizQuestionNo;
        this.countryQuizQuestionNo = countryQuizQuestionNo;
        this.plantQuizQuestionNo = plantQuizQuestionNo;
    }
    
    public QuizMenu(){
        
        //this.plantQuizQuestionNo = 1;
    }
    
    
    
    // Method to display menu
    public void menu(){
        
        
        int choice = 0;
        
        do{
            System.out.println("\nPlease select a category");
            System.out.println("1. Animal");
            System.out.println("2. Country");
            System.out.println("3. Plant");
            System.out.println("4. Exit");
            
            System.out.print("\nEnter your choice> ");
            choice = getChoice();
            
            switch(choice){
                case 1: 
                    System.out.println("");
                    animalQuizQuestionNo = animalQuiz();
                    break;
                case 2:
                    System.out.println("");
                    countryQuizQuestionNo = countryQuiz();
                    break;
                case 3:
                    System.out.println("");
                    plantQuizQuestionNo = plantQuiz();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please select (1-4)!!!\n");
            }
        }while(choice != 4);
        
        
       
        
    }
    
    // Method to display animal quiz to user
    public int animalQuiz(){
        
        int questionNumber = 0;
        
        boolean validity = true;
        
        //Check if animalList is empty
        if(animalList.isEmpty())
            readQuiz(animalList, "Animal.bin"); //Read animal quiz from file to animalList
        
        System.out.println("-------- Animal Quiz --------");
        
        // Check if user already answer all the question for this category
        if(animalQuizQuestionNo > animalList.size()){ // If yes, system will show question and answer to user.
            previewQuestion(animalList);
            return animalQuizQuestionNo;
        }else{ // If no, system will continue let user answerring
            questionNumber = animalQuizQuestionNo;
            
            do{
                if(questionNumber == animalList.size()){
                    validity = displayQuiz(animalList, "Animal.bin", questionNumber);
                    if(validity == false)
                        return animalList.size();
                }else
                    validity = displayQuiz(animalList, "Animal.bin", questionNumber);

                if(animalList.size() >= questionNumber){
                    if(questionNumber == animalList.size()){
                        System.out.println("Congratulation!!! Your are completed all the qeuestion for this category ^-^.\n");
                        questionNumber++;
                        validity = false;
                    }
                    else
                        questionNumber++;
                }else{
                    validity = false;
                } 


            }while(validity);
        }
        
        //Return question number for storing purpose when user exit this quiz
        if((questionNumber - 1) ==  animalList.size())
            return questionNumber;
        else
           return (questionNumber - 1);
        
    }
    
    // Display contry quiz to user
    public int countryQuiz(){
        
        int questionNumber = 0;
        
        boolean validity = true;
        
        // Check if country list is empty
        if(countryList.isEmpty())
            readQuiz(countryList, "Country.bin");  // read country quiz from binary file to countryList
        
        System.out.println("-------- Country Quiz --------");
        
        // Check if user already answering all the question under this category
        if(countryQuizQuestionNo > countryList.size()){
            previewQuestion(countryList); // If yes, let user view the question and answer
            return countryQuizQuestionNo;
        }else{ // if no, let user continue to answer
            
            questionNumber = countryQuizQuestionNo;
            
            do{

   
                    if(questionNumber == countryList.size()){
                        validity = displayQuiz(countryList, "Country.bin", questionNumber);
                        System.out.println("Congratulation!!! Your are completed all the qeuestion for this category ^-^.\n");
                        
                        if(validity == false)
                            return countryList.size();
                    }else
                        validity = displayQuiz(countryList, "Country.bin", questionNumber);
                if(countryList.size() >= questionNumber){
                    if(questionNumber == countryList.size()){
                        System.out.println("Congratulation!!! Your are completed all the qeuestion for this category ^-^.\n");
                        questionNumber++;
                        validity = false;
                    }else
                        questionNumber++;
                }else
                    validity = false;

            }while(validity);
        }
        
        // retrun current question number for storing purpose when user exit this quiz
        if((questionNumber - 1) == countryList.size())
            return questionNumber;
        else
            return (questionNumber - 1);
    }
    
    // Display plant quiz to user
    public int plantQuiz(){
        
        int questionNumber = 0;
        
        boolean validity = true;
        
        // Check if plantList is empty
        if(plantList.isEmpty())
            readQuiz(plantList, "Plant.bin"); // Read plant quiz from binary file to plantList
        
        System.out.println("-------- Plant Quiz --------");
        
        //Check if user already complete all the question under this category
        if(plantQuizQuestionNo > plantList.size()){  // If yes, let user to view question and answer
            previewQuestion(plantList); 
            return plantQuizQuestionNo;
        }else{ // if no, let user continue to answer
            questionNumber = plantQuizQuestionNo;
            
            do{
                if(questionNumber == plantList.size()){
                    validity = displayQuiz(plantList, "Plant.bin", questionNumber);
                    if(validity == false)
                        return plantList.size();
                }else
                    validity = displayQuiz(plantList, "Plant.bin", questionNumber);

                if(plantList.size() >= questionNumber){
                    if(questionNumber == plantList.size()){
                        System.out.println("Congratulation!!! Your are completed all the qeuestion for this category ^-^.\n");
                        questionNumber++;
                        validity = false;
                    }
                    else
                        questionNumber++;
                }else{
                    validity = false;
                } 


            }while(validity);
        }
        
        // retrun current question number for storing purpose when user exit this quiz
        if((questionNumber - 1) ==  plantList.size())
            return questionNumber;
        else
           return (questionNumber - 1);
        
    }
    
    // Display quiz for user to answer
    public boolean displayQuiz(CircularLinkedListInterface list, String fileName, int questionNumber){
        
        Scanner scan = new Scanner(System.in);
        String answer;
        int tempQuestionNumber = 0;
        boolean validity;
        
        // Display question for the quiz
        displayQuestion(list, questionNumber);
        
        do{
            System.out.print("Enter Answer (-1 to exit, 0 to view previous question)> "); // Prompt user enter answer
            answer = scan.nextLine();
            
            //Check if answer is correct
            if(checkAnswer(list, answer, questionNumber)){
                System.out.println("congrate!!!");
                return true;
            }else if(answer.equals("0")){  // If user press '0' go to previous question
                
                if(questionNumber == 1){
                    System.out.println("There is not previous question!!!\n");
                }else{
                    tempQuestionNumber = questionNumber;
                    validity = getPreviousQuestion(list, tempQuestionNumber, questionNumber);
                    if(validity == false)
                        answer = "-1";
                }
                
            }
            else if(!(checkAnswer(list, answer, 1)) && !(answer.equals("-1"))){  // Show when user enter invalid input or incorrect answer
                System.out.println("Incorrect answer please try again\n");
            }
        
        }while(!(answer.equals("-1")));
        
        return false;
    }
    
    // Let user preview the quiz question and answer as user already complete it
    public void previewQuestion(CircularLinkedListInterface list){
        
        int action = 0;
        int tempQuestionNumber = 1;
        boolean validity = true;
        
        System.out.println("\nCongrate!!! You are completed all question under this category!!!");
        displayQuestion(list, tempQuestionNumber);
        Question question = (Question)list.get(tempQuestionNumber);
        System.out.println("Answer: " + question.getQuestionAnswer() + "\n");
        
        System.out.print("(-1 to exit, 0 to view previous question, 1 to view next question)> ");
        action = getAction();
        
        do{
            
            switch (action) {
                case 0:
                    if(tempQuestionNumber != 1){
                        --tempQuestionNumber;
                        displayQuestion(list, tempQuestionNumber);
                        question = (Question)list.get(tempQuestionNumber);
                        System.out.println("Answer: " + question.getQuestionAnswer() + "\n");
                        
                        System.out.print("(-1 to exit, 0 to view previous question, 1 to view next question)> ");
                        action = getAction();
                    }
                    else{
                        System.out.println("There is not previous question!!!");
                        System.out.print("(-1 to exit, 0 to view previous question, 1 to view next question)> ");
                        action = getAction();
                    }   break;
                case 1:
                    if(++tempQuestionNumber == (list.size() + 1)){
                        validity = false;
                        System.out.println("There is the end of the question ^-^");
                    }
                    else{
                        displayQuestion(list, tempQuestionNumber);
                        question = (Question)list.get(tempQuestionNumber);
                        System.out.println("Answer: " + question.getQuestionAnswer() + "\n");
                        
                        System.out.print("(-1 to exit, 0 to view previous question, 1 to view next question)> ");
                        action = getAction();
                    }   break;
                case -1:
                    validity = false;
                    break;
                default:
                    System.out.print("(-1 to exit, 0 to view previous question, 1 to view next question)> ");
                    action = getAction();
                    break;
            }
            
        }while(validity == true);
         
         
    }
    
    // Display previous question to user
    public boolean getPreviousQuestion(CircularLinkedListInterface list, int tempQuestionNumber, int currentQuestionNumber){
        
        int action = 0;
        Scanner scan = new Scanner(System.in);
        
         displayQuestion(list, --tempQuestionNumber);
         Question question = (Question)list.get(tempQuestionNumber);
         System.out.println("Answer: " + question.getQuestionAnswer() + "\n");
         
        do{
            System.out.print("(-1 to exit, 0 to view previous question, 1 to view next question)> ");
            action = getAction();
            
            if(action == 0){
                if(tempQuestionNumber != 1){
                    displayQuestion(list, --tempQuestionNumber);
                    question = (Question)list.get(tempQuestionNumber);
                    System.out.println("Answer: " + question.getQuestionAnswer() + "\n");
                }  
                else
                    System.out.println("There is not previous question!!!");
            }else if(action == 1){
                if(++tempQuestionNumber != currentQuestionNumber){
                    displayQuestion(list, tempQuestionNumber);
                    question = (Question)list.get(tempQuestionNumber);
                    System.out.println("Answer: " + question.getQuestionAnswer() + "\n");
                }   
                else{
                    displayQuestion(list, currentQuestionNumber);
                }
            }else if(action == -1){
                System.out.println();
                return false;
            }else{
                System.out.print("");
            }
 
        }while((tempQuestionNumber != currentQuestionNumber));
        
        return true;
    }
    
    // Read quiz from binary file to CircularLinkedList
    public void readQuiz(CircularLinkedListInterface list, String fileName){
        
        // To read question from binary file 
        Question[] question = new Question[100];
     
        ReadWriteFile readWriteFile = new ReadWriteFile();
        
        int noOfElement = readWriteFile.read(question, fileName);
        
        // Write the result from binary file to linkedlist
        for(int i = 0; i < noOfElement; i++){
            
            list.add(question[i]);
            
        }
        
    }
    
    // Check if question is empty or end of quuestion
    public boolean checkQuestion(CircularLinkedListInterface list, int level){
        
        if((list.get(level)) != null){
            return true;
        }else 
            return false;
    }
    
    // Display question to user
    public void displayQuestion(CircularLinkedListInterface list, int level){
        
        if(checkQuestion(list, level)){
            
            Question question = (Question)list.get(level);
            
            System.out.println("");
            System.out.println("Level " + question.getLevel() + "\n");
            System.out.println(question.getQuestionTitle());
           
        }
            
        
    }
    
    // Validate the answer return true when correct
    public boolean checkAnswer(CircularLinkedListInterface list, String answer, int level){
        
        Question question = (Question)list.get(level);
        
        if((question.validateAnswer(answer)))
            return true;
        else
            return false;
        
    }
    
    // Capture exception when user enter other than int
    public static int getChoice(){
        
        Scanner scan = new Scanner(System.in);
        
        while(true){
            try{
                return scan.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Please enter an digit!!!");
                System.out.print("\nEnter your choice> ");
                scan.next();
            }
        }
    }
    
    // Capture exception when user enter other than int
    public static int getAction(){
        
        Scanner scan = new Scanner(System.in);
        
        while(true){
            try{
                return scan.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Please enter an digit!!!");
                System.out.print("\n(-1 to exit, 0 to view previous question, 1 to view next question)> ");
                scan.next();
            }
        }
    }
    
    // Getter 
    public int getAnimalQuizQuestonNo() {
        return animalQuizQuestionNo;
    }

    public int getCountryQuizQuestonNo() {
        return countryQuizQuestionNo;
    }

    public int getPlantQuizQuestonNo() {
        return plantQuizQuestionNo;
    }
    
    // Setter
    public void setAnimalQuizQuestonNo(int animalQuizQuestionNo) {
        this.animalQuizQuestionNo = animalQuizQuestionNo;
    }

    public void setCountryQuizQuestonNo(int countryQuizQuestionNo) {
        this.countryQuizQuestionNo = countryQuizQuestionNo;
    }

    public void setPlantQuizQuestonNo(int plantQuizQuestonNo) {
        this.plantQuizQuestionNo = plantQuizQuestionNo;
    }
    
    
    
    
}
