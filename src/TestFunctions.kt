import org.junit.Test
import kotlin.test.assertEquals

class Test{
    @Test
    fun TestOfDataManagement() {
        var TestUser = User()
        var TestDataManagement = DataManagement()
        var TestMasterList = MasterList()
        assertEquals(10, TestDataManagement.PopulateCurrentWords(TestUser, TestMasterList), "Populated the List with Ten Words")
        //assertEquals(11, TestMasterList.AddWord(TestMasterList), "Added another word to the List")
    }
}