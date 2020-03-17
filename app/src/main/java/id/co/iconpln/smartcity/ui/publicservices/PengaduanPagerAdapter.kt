package id.co.iconpln.smartcity.ui.publicservices

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.co.iconpln.smartcity.ui.publicservices.jenispengaduan.JenisPengaduanFragment
import id.co.iconpln.smartcity.ui.publicservices.pengaduan.DataPengaduanFragment


class PengaduanPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {

     override fun getCount(): Int {
         return 2
     }

     override fun getItem(position: Int): Fragment {
         return when (position) {
             0 -> {
                 DataPengaduanFragment()
             }
             else -> {
                 JenisPengaduanFragment()
             }

         }
     }

     override fun getPageTitle(position: Int): CharSequence? {
         return when(position){
             0->"Data Pengaduan"
             else->"Jenis Pengaduan"
         }
     }

}


/* lateinit var fragmentList: ArrayList<Fragment>
 lateinit var fragmentTitleList: ArrayList<String>


 override fun getItem(position: Int): Fragment {
    return fragmentList.get(position)
 }

 override fun getCount(): Int {
     return fragmentList.size
 }

 fun addFragment(fragment: Fragment, title: String){
     fragmentList.add(fragment)
     fragmentTitleList.add(title)
 }

 override fun getPageTitle(position: Int): CharSequence? {
//        return fragmentTitleList(position)
     return null
 }*/

/* fun getTabView(position:Int):View {
     val view = LayoutInflater.from(context).inflate(R.layout.custom_tabpengaduan, null)
     val tabTextView = view.findViewById<TextView>(R.id.tabtext)
     tabTextView.setText(fragmentTitleList.get(position))
     return view
 }

 fun getSelectedTabView(position: Int): View{
     val view = LayoutInflater.from(context).inflate(R.layout.custom_tabpengaduan, null)
     val tabTextView = view.findViewById<TextView>(R.id.tabtext)
     tabTextView.setText(fragmentTitleList.get(position))
     tabTextView.setTextColor(getColor(context,R.color.colorPrimary))
     return view
 }*/

