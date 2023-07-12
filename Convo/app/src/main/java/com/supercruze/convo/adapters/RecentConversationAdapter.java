package com.supercruze.convo.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.supercruze.convo.databinding.ItemContainerRecentConversationsBinding;
import com.supercruze.convo.listners.ConversationListner;
import com.supercruze.convo.models.ChatMessage;
import com.supercruze.convo.models.User;

import java.util.List;

public class RecentConversationAdapter extends RecyclerView.Adapter<RecentConversationAdapter.ConversationViewHolder>{

    private final List<ChatMessage> chatMessages;
    private final ConversationListner conversationListner;


    public RecentConversationAdapter(List<ChatMessage> chatMessages, ConversationListner conversationListner) {
        this.chatMessages = chatMessages;
        this.conversationListner = conversationListner;
    }

    @NonNull
    @Override
    public ConversationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ConversationViewHolder(
                ItemContainerRecentConversationsBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ConversationViewHolder holder, int position) {
           holder.setData(chatMessages.get(position));
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    class ConversationViewHolder extends RecyclerView.ViewHolder {

        ItemContainerRecentConversationsBinding binding;

        ConversationViewHolder(ItemContainerRecentConversationsBinding itemContainerRecentConversationsBinding){
            super(itemContainerRecentConversationsBinding.getRoot());
            binding = itemContainerRecentConversationsBinding;
        }

        void setData(ChatMessage chatMessage){
            binding.imageProfile.setImageBitmap(getConversationImage(chatMessage.conversationImage));
            binding.textName.setText(chatMessage.conversationName);
            binding.textRecentMessage.setText(chatMessage.message);
            binding.getRoot().setOnClickListener(v -> {
                User user = new User();
                user.id = chatMessage.conversationId;
                user.name = chatMessage.conversationName;
                user.image = chatMessage.conversationImage;
                conversationListner.onConversationClicked(user);
            });
        }
    }

    private Bitmap getConversationImage(String endcodedImage){
        byte[] bytes = Base64.decode(endcodedImage,Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length);
    }
}
