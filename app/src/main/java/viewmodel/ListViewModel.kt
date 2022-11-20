package viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.models.Shoe


class ListViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    //here we use mutableliveData as live data for encapsulation
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList


   val shoeName = MutableLiveData<String>()
    val shoeDescription = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()






    init {
      //  initialize
        shoeName.value = ""
        shoeSize.value = ""
        shoeCompany.value = ""
        shoeDescription.value = ""

    }
    fun shoeListEmptyOrNot(): Boolean {
        // we use this fun because we have a text in shoe_listing that we hide it if the list not empty
        return _shoeList.value == null
    }
    fun resetEditText(){
        //here i reset edit text to clean it
        shoeSize.value = ""
        shoeCompany.value = ""
        shoeName.value = ""
        shoeDescription.value = ""
    }


    fun createshoe() {
        //create shoe object

        val shoe = Shoe(
            shoeName.value ?: "",
            shoeSize.value?.toDouble()?: 0.0,
            shoeCompany.value ?: "",
            shoeDescription.value ?: ""
        )
//        //if list are null initialize it and add the shoe object to it for first time
        if (shoeListEmptyOrNot()){
            _shoeList.value = mutableListOf(shoe)

        }else{
            //add object to the list if it is not null
            _shoeList.value?.add(shoe)


        }


    }
}