import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.login.Anime
import com.example.login.R

class RecyclerViewAdapter(llistat: ArrayList<Anime>, context: Context?): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    var llistat: ArrayList<Anime> = llistat;
    var context: Context? = context;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtTitleList.setText(llistat.get(position).title)
        holder.txtGenreList.setText(llistat.get(position).genre)
        holder.txtSeasonList.setText(llistat.get(position).season)
    }

    override fun getItemCount(): Int {
        return llistat.size;
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtTitleList: TextView = view.findViewById(R.id.txtTitleList);
        val txtGenreList: TextView = view.findViewById(R.id.txtGenreList);
        val txtSeasonList: TextView = view.findViewById(R.id.txtSeasonList);
    }

}
