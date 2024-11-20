package com.example.umc7thflo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc7thflo.databinding.ItemAlbumBinding

class AlbumRVAdapter(private val albumList: ArrayList<Album>): RecyclerView.Adapter<AlbumRVAdapter.ViewHolder>() {

    interface MyItemClickListner {
        fun onItemClick(album: Album)
        fun onRemoveAlbum(position: Int)
    }

    private lateinit var mItemClickListner: MyItemClickListner
    fun setMyItemClickListner(itemClickListener: MyItemClickListner) {
        mItemClickListner = itemClickListener
    }

    fun addItem(album: Album) {
        albumList.add(album)
        notifyDataSetChanged()  // 데이터가 변경된 것을 알려주기 위해 사용
    }

    fun removeItem(position: Int) {
        albumList.removeAt(position)
        notifyDataSetChanged()  // 데이터가 변경된 것을 알려주기 위해 사용
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AlbumRVAdapter.ViewHolder {  // ViewHolder를 생성해주어야 할 때 호출
        // 아이템뷰 객체를 만든 후에 이를 재활용하기 위해 ViewHolder에 던져줌
        val binding: ItemAlbumBinding = ItemAlbumBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumRVAdapter.ViewHolder, position: Int) {  // ViewHolder에 데이터를 바인딩해 주어야 할 때마다 호출
        // 사용자가 화면을 위아래로 스크롤 할 때마다 엄청나게 많이 호출됨
        // position은 index의 ID
        holder.bind(albumList[position])

        // 클릭이벤트
        holder.itemView.setOnClickListener { mItemClickListner.onItemClick(albumList[position]) }

        // 앨범 삭제
//        holder.binding.itemAlbumTitleTv.setOnClickListener { mItemClickListner.onRemoveAlbum(position) }
    }

    // DataSet의 크기를 알려주는 함, RecyclerView의 마지막이 어디인 지 알려줌
    override fun getItemCount(): Int = albumList.size

    // ViewHolder는 아이템뷰 객체들을 재활용하기 위해서 날라가지 않도록 담고 있는 그릇이므로 매개변수로 아이템뷰 객체를 받아와야 함
    inner class ViewHolder(val binding: ItemAlbumBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Album) {
            binding.itemAlbumTitleTv.text = album.title
            binding.itemAlbumSingerTv.text = album.singer
            binding.itemAlbumCoverImgIv.setImageResource(album.coverImg!!)
        }
    }

}