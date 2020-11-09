import kotlin.system.exitProcess

//Justin Holsclaw 11/2/2020
//This Program is intended to Allow the User to Test him or herself on words in the Spanish
//Language. The User may add words to the MasterList and then once they have passed off the current Words
//They will receive new ones from the program.


fun main(args: Array<String>) {
    var CurrentUser = User()
    var LocalDataManagement = DataManagement()
    var LocalLanguageTestSuit = LanguageTests()
    var LocalMaster = MasterList()
    var UserSelection:String = " "
while(UserSelection != "exit") {
    PrintMenu()
    UserSelection = LocalDataManagement.UserIn()
    when (UserSelection) {
        "test" -> LocalLanguageTestSuit.TestUserWordList(CurrentUser, LocalMaster) //This calls the test Word Function
        "add word" -> LocalMaster.AddWord(LocalMaster, CurrentUser)
        "reset word list" -> LocalDataManagement.ResetUserWordCount(CurrentUser)
        "Exit" -> exitProcess(0)
        else -> print("Invalid Input\n")
    }

}
}

fun PrintMenu(){ //This function just prints out the menu each time that a function ceases to run.
    print("Please type in the one of the following options: \n")
    print("Test\n")
    print("Add Word\n")
    print("Reset Word List\n")
    print("Exit\n")
}

