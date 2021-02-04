class User {
        var FirstName: String = ""
        var LastName: String = ""
        var UserLoginId: String = "$FirstName.$LastName"
        val Id: Int = 111111
        var CurrentWords = mutableListOf<Word>()
}

class UserCreation{
    fun CreateUser(currentUser: User){

    }
}

class Word //Each Word Contains a TimesCompleted value which indicates how many times the user has correctly passed off a word.
(   var Word: String = "",
    var NumberOfTimesCompleted: Int = 0
);

class DataManagement{ //Datamanagment recieves user input and makes sure it is in the proper format
    fun UserIn(): String{
       var UserIn = readLine()!!
       var ChangeToLowerCase = fun(UserInput:String):String { //This function takes in User Input and returns a String in the lowercase, making it so that it is not case specific.
            var LocalUserInput = UserInput.toLowerCase()
            return LocalUserInput
        }
        return ChangeToLowerCase(UserIn)
    }

    fun PopulateCurrentWords(CurrentUser:User, LocalMasterList:MasterList):Int{//This function takes ten values from the master list and populates the current user List with them.
        var LocalListOfKeys = LocalMasterList.CurrentWordMap.values.take(10)
        for(word in LocalListOfKeys){
            CurrentUser.CurrentWords.add(Word(word))
        }
        return CurrentUser.CurrentWords.size
    }

    fun ResetUserWordCount(CurrentUser: User){//Uses the Map function to Reset the Number of times Completed for the Entire List.
        CurrentUser.CurrentWords.map{ Word(NumberOfTimesCompleted = 0) }
    }

    fun ChangeUserName(CurrentUser: User){ //Changes the Name of the Current User.
        CurrentUser.run {
            FirstName = UserIn()
            LastName = UserIn()
        }
    }
}