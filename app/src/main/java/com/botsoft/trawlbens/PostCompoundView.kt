package com.botsoft.trawlbens

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.post_view.view.*

class PostCompoundView @JvmOverloads constructor(context: Context,
                                                 attrs: AttributeSet? = null,
                                                 defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr)  {

    init {
        val a: TypedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.ColorOptionsView, 0, 0
        )

        val descText = a.getString(R.styleable.ColorOptionsView_description)
        val verified = a.getString(R.styleable.ColorOptionsView_verified)
        val rating = a.getString(R.styleable.ColorOptionsView_rate)
        val url = a.getDrawable(R.styleable.ColorOptionsView_url)

        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.post_view, this,true)

        val titleText = a.getString(R.styleable.ColorOptionsView_title)
        view.title.text = titleText
        view.subtitle.text = descText
        if (verified.equals("1"))
            view.img_verified.visibility = View.VISIBLE
            else
            view.img_verified.visibility = View.GONE
        img_thumb.setImageDrawable(url)

        if( 1 <= rating!!.toInt())
            view.star1.alpha = 1F
        if( 2 <= rating!!.toInt())
            view.star2.alpha = 1F
        if( 3 <= rating!!.toInt())
            view.star3.alpha = 1F
        if( 4 <= rating!!.toInt())
            view.star4.alpha = 1F
        if( 5 <= rating!!.toInt())
            view.star5.alpha = 1F
    }

}