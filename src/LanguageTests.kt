

class LanguageTests {
    var LocalDataManagement = DataManagement()

    fun TestUserWordList(CurrentUser:User, LocalMasterList:MasterList) {
        if(CurrentUser.CurrentWords.isEmpty()== true){ //if the List is empty it populates the list
            LocalDataManagement.PopulateCurrentWords(CurrentUser, LocalMasterList)
        }
        var ListSize = CurrentUser.CurrentWords.size
        var CorrectAnswer = 0
        for (x in 0 until ListSize) { //For each word in the User List it test them and their value vs the user Answer.
            print("${CurrentUser.FirstName} how do you say ${CurrentUser.CurrentWords.elementAt(x).Word} in Spanish\n")
            var Answer = LocalDataManagement.UserIn()

            if (LocalMasterList.CurrentWordMap.get(Answer) != null) {
                print("Correct Answer\n")
                CurrentUser.CurrentWords.elementAt(x).NumberOfTimesCompleted = CurrentUser.CurrentWords.elementAt(x).NumberOfTimesCompleted +1 // adds one onto the current value of the number of times its been passed off.
                CorrectAnswer++
            } else {
                print("Sorry ${CurrentUser.FirstName} thats the wrong answer\n")
            }
        }
        print("Nice ${CurrentUser.FirstName} you scored $CorrectAnswer out of 10\n")
    }
}