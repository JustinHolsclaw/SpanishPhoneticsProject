import java.lang.instrument.ClassDefinition

class MasterList {
    var LocalDataManagement = DataManagement()
    var CurrentWordMap = mutableMapOf<String,String>("hola" to "hello", "como estas" to "how are you", "que" to "what",
        "quien" to "who", "como" to "how", "buenas noches" to "good night", "bien" to "good", "mal" to "bad",
        "mas o menos" to "more or less", "que pasa" to "what's up")
}

fun MasterList.AddWord(LocalMasterList:MasterList, CurrentUser:User){ //adds a word to the masterlist and adds it as the second element in UserList
    print("Please input your new word in Spanish\n")
    var spanishWord = LocalDataManagement.UserIn()
    print("Please input your new word in English\n")
    var englishWord = LocalDataManagement.UserIn()
    LocalMasterList.CurrentWordMap.put(spanishWord, englishWord)
    if(CurrentUser.CurrentWords.isEmpty()== true){ //if the List is empty it populates the list
        LocalDataManagement.PopulateCurrentWords(CurrentUser, LocalMasterList)
    }
    CurrentUser.CurrentWords[1].Word = englishWord // adds the english word to the user list
}