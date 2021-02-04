import java.util.*
import kotlin.random.Random

//Using Hash Tables I will implement a question and response system that allows the user to get a quiz of phrases based off
//the categorization of the conversation.
class phrases {
    fun initialize(){

    }
    var subjects = mutableMapOf<String, subjectObj>()

    fun seeSubjects(){
        println("Current Subjects:" + subjects.keys)
    }

    fun seePhrasesOfSubject(){
        var dataManagementInstance = DataManagement()
        println("Which subject would you like to see the phrases of?")
        seeSubjects()
        var subject = dataManagementInstance.UserIn()
        println("Current Phrases for subject " + subject + ":" + subjects.getValue(subject).listOfMaps
                ?: "Subject does not exist in the List")
    }

    fun addPhraseAndSubject(){
        var dataManagementInstance = DataManagement()
        println("Please enter the subject")
        println("Please see the list of current subject and check for current subjects that may fight your phrase.")
        seeSubjects()
        var subject = dataManagementInstance.UserIn()
        println("Please enter the phrase, this will be associated with the subject.")
       var phrase = dataManagementInstance.UserIn()
        println("Please enter the response that you want the user to select.")
       var response = dataManagementInstance.UserIn()
        if(subjects.containsKey(subject)){
            subjects.getValue(subject).phraseMap.put(phrase, response)
            subjects.getValue(subject).listOfMaps.add(phrase)
        }
       else{
           println("This subject did not exist in the current list and was added")
            subjects.put(subject, subjectObj())
            subjects.getValue(subject).phraseMap.put(phrase, response)
            subjects.getValue(subject).listOfMaps.add(phrase)
        }
   }
/*
    fun getOtherAnswers(subject: String):String{
        var subjectObjInstance = subjectObj()
        var randomValues = Random
        var faker = subjectObjInstance.phraseMap.entries.elementAt(Random.nextInt(subjectObjInstance.phraseMap.size))
        var fakeAnswer = faker.value
        var answer = subjectObjInstance.phraseMap.getValue(subject)
        if( fakeAnswer == answer){
           answer = getOtherAnswers(subject)
        }
        return answer
    }
*/
    fun quizPhrases(){
        var dataManagementInstance = DataManagement()
        println("Please type in one of the following subjects\n")
        seeSubjects()
        println("\n")
        var subject = dataManagementInstance.UserIn()
        var localListOfPhrases = subjects.get(subject)?.listOfMaps
        var localPhraseMap = subjects.get(subject)?.phraseMap
        var i =0
        while(i < localListOfPhrases!!.size){
            println("What is the correct response to the following question, type in the corresponding number")
            println(localListOfPhrases[i])
            var (a,b) = Pair(localPhraseMap?.get(localListOfPhrases[i]), 4)
            println("1. Not this one")
            println("2. Maybe this one")
            println("3. Possibly")
            println("4. " + (a) + "\n")
            val reader = Scanner(System.`in`)
            var selection:Int = reader.nextInt()
            var score = 0
            if(selection == (b)){
                println("That was correct\n")
                score++
            }
            else{
                println("incorrect")
            }
            i++
        }
    }
}

class subjectObj{
    var listOfMaps = mutableListOf<String>()
   var phraseMap = mutableMapOf<String, String>()
}

