package net.larntech.firestore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.android.synthetic.main.row_users.view.*

class UserAdapter(options: FirestoreRecyclerOptions<UsersModel>) :
    FirestoreRecyclerAdapter<UsersModel, UserAdapter.UserAdapterVH>(options) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapterVH {
      return UserAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.row_users,parent,false))
    }

    override fun onBindViewHolder(holder: UserAdapterVH, position: Int, model: UsersModel) {

        holder.userName.text = model.userName;
        holder.user_email.text = model.userEmail
        holder.user_phone.text = model.userPhone

    }

    class UserAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var userName = itemView.tvUsername
        var user_email = itemView.tvUserEmail
        var user_phone = itemView.tvUserPhone

    }
}