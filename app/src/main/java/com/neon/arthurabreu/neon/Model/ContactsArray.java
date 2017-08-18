package com.neon.arthurabreu.neon.Model;

import com.neon.arthurabreu.neon.R;

import java.util.ArrayList;

/**
 * Created by desenv on 18/08/17.
 */

public class ContactsArray {

    private ArrayList<Contacts> contactsArrayList = new ArrayList<>();

    public ContactsArray()
    {
        contactsArrayList.add(new Contacts(1, "1", "202-555-0121", "Ned Stark", R.drawable.ned, 0));
        contactsArrayList.add(new Contacts(2, "2", "202-555-0193", "Robert Baratheon", R.drawable.robert, 0));
        contactsArrayList.add(new Contacts(3, "3", "202-555-0158", "Jaime Lannister", R.drawable.jaime, 0));
        contactsArrayList.add(new Contacts(4, "4", "202-555-0129", "Catelyn Stark", R.drawable.catelyn, 0));
        contactsArrayList.add(new Contacts(5, "5", "202-555-0182", "Cersei Lannister", R.drawable.cersei, 0));
        contactsArrayList.add(new Contacts(6, "6", "202-555-0149", "Jorah Mormont", R.drawable.jorah, 0));
        contactsArrayList.add(new Contacts(7, "7", "506-900-6948", "Petyr Baelish", R.drawable.petyr, 0));
        contactsArrayList.add(new Contacts(8, "8", "269-943-0197", "Jon Snow", R.drawable.jon, 0));
        contactsArrayList.add(new Contacts(9, "9", "125-794-1294", "Sansa Stark", R.drawable.sansa, 0));
        contactsArrayList.add(new Contacts(10, "10", "423-890-3212", "Arya Stark", R.drawable.arya, 0));
        contactsArrayList.add(new Contacts(11, "11", "979-772-7700", "Bran Stark", R.drawable.bran, 0));
        contactsArrayList.add(new Contacts(12, "12", "441-493-0618", "Davos Seaworth", R.drawable.davos, 0));
        contactsArrayList.add(new Contacts(13, "13", "818-723-0802", "Bronn", R.drawable.bronn, 0));
        contactsArrayList.add(new Contacts(14, "14", "938-891-9998", "Tyrion Lannister", R.drawable.tyrion, 0));
        contactsArrayList.add(new Contacts(15, "15", "128-604-5116", "Margaery Tyrell ", R.drawable.margaery, 0));
    }
    public ArrayList<Contacts> getContactsArrayList() {
        return contactsArrayList;
    }
}
