package com.example.materialdesigntoolbarexample2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class MyAdapterMain extends RecyclerView.Adapter<MyAdapterMain.ViewHolder>{
	
	private String mNavTitles[]; 
	private int mIcons[];    
	static int posCard;
	Context context;
	private static ClickListener cListener;
	public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
	
		TextView textView;  
		ImageView imageView;
		Context contxt;
			public ViewHolder(View itemView,int ViewType, Context c) { //provide findviewbyid               
					super(itemView);
								//items list
						textView = (TextView) itemView.findViewById(R.id.info_text_header); 
						imageView = (ImageView) itemView.findViewById(R.id.info_image);
						contxt = c;
						
						 itemView.setClickable(true);
				         itemView.setOnClickListener(this);
			}
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// Toast.makeText(contxt,"The Item Clicked is: "+getPosition(),Toast.LENGTH_SHORT).show();
				if(cListener != null){
					cListener.itemClicked(v, getPosition());
				}
				
			}
			
			
	}
	MyAdapterMain(String Titles[],int Icons[],Context passedContext){ 
			mNavTitles = Titles;                
			mIcons = Icons;        
			 this.context = passedContext;
	}
	@Override
	public MyAdapterMain.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {  // java converter inflate
			View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false); 
					
				ViewHolder vhItem = new ViewHolder(v,viewType, context); 
					return vhItem; 
	}
	@Override
	public void onBindViewHolder(MyAdapterMain.ViewHolder holder, int position) {
			
					holder.textView.setText(mNavTitles[position]); 
					holder.imageView.setImageResource(mIcons[position]);
					/*holder.textView.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							
						}
					});*/
	}
	public void setClickListener(ClickListener cListener){
		this.cListener=cListener;
	}
	@Override
	public int getItemCount() {
		return mNavTitles.length; // the number of items in the list will be +1 the titles including the header view.
	}
	public interface ClickListener{
		public void itemClicked(View view, int position);
	}
	
}
