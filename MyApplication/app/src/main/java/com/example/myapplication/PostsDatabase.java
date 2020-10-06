package com.example.myapplication;

import androidx.annotation.NonNull;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class PostsDatabase extends Database {

    private long Size;
    private ArrayList<Publicacion> posts;


    public PostsDatabase(String p){
        super(p);
        Size = 0;
        posts = new ArrayList<Publicacion>();
    }

    public void newPost(Publicacion p){
        reference.child(Long.toString(p.getId())).setValue(p);
    }

    public ArrayList<Publicacion> getPosts(){
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                long count = snapshot.getChildrenCount();
                ArrayList<Publicacion> temp = new ArrayList<Publicacion>();
                for(long i = 0; i<count; i++){
                    String index = Long.toString(i+1);
                    String description = snapshot.child(index).child("description").getValue().toString();
                    String location = snapshot.child(index).child("location").getValue().toString();
                    String type = snapshot.child(index).child("type").getValue().toString();
                    String user = snapshot.child(index).child("user").getValue().toString();
                    Publicacion p = new Publicacion(user,location,type,description);
                    temp.add(p);
                }
                posts = temp;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        System.out.println(posts);
        return posts;

    }

    public long getSize(){
        reference.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot
                        Size = dataSnapshot.getChildrenCount();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

        return Size;
    }

}
