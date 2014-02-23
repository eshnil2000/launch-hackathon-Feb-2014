package com.github.barcodeeye.scan.result.internal;

import java.util.ArrayList;
import java.util.List;

//import android.R;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.github.barcodeeye.scan.api.CardPresenter;
import com.github.barcodeeye.scan.result.ResultProcessor;
import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;
import com.github.barcodeeye.R;
import android.content.DialogInterface;

public class TextResultProcessor extends ResultProcessor<ParsedResult>  implements DialogInterface.OnClickListener {
	
    private static final String TAG = TextResultProcessor.class.getSimpleName();
  
    
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
    	Log.w("Click", "click occur");
    }
    
    private static final String SEARCH_URL = "https://www.google.com/search?q=%s";
    
    public TextResultProcessor(Context context, ParsedResult parsedResult,
            Result result, Uri photoUri) {
        super(context, parsedResult, result, photoUri);
    }

    @Override
    public List<CardPresenter> getCardResults() {
    	
    	
    	
        List<CardPresenter> cardPresenters = new ArrayList<CardPresenter>();

        ParsedResult parsedResult = getParsedResult();
        String codeValue = parsedResult.getDisplayResult();
        
      //CARD #1
        CardPresenter cardPresenter = new CardPresenter();
        cardPresenter.setText("Van Heusen ").setFooter("USD:$14.99, BTC:0.0239");
        //cardPresenter.setText("Alfani fitted blue ").setFooter(Double.toString(rate));
        
        cardPresenter.addImage(getContext(),R.drawable.blue_shirt);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(String.format(SEARCH_URL, codeValue)));
        
        cardPresenter.setPendingIntent(createPendingIntent(getContext(), intent));
        
        cardPresenters.add(cardPresenter);
      //END CARD #1
        
      //CARD #2
        cardPresenter = new CardPresenter();
        cardPresenter.setText("Pay with BitPay Account: USD:$14.99, BTC:0.0239").setFooter("Current BTC Exchange rate: 1BTC=$625");
        cardPresenter.addImage(getContext(),R.drawable.btc2);
       // Intent intent2 = new Intent(Intent.ACTION_VIEW);
       // intent2.setData(Uri.parse(String.format(SEARCH_URL, codeValue)));
        
        //cardPresenter.setPendingIntent(createPendingIntent(getContext(), intent));
        //System.out.println(cardPresenters.indexOf(cardPresenter));
        //Log.d(TAG, Integer.toString(cardPresenters.indexOf(cardPresenter)));
        cardPresenters.add(cardPresenter);
      //END CARD #2
        

        
      //CARD #3
        cardPresenter = new CardPresenter();
        cardPresenter.setText("Price Match: Macy's: $14.99").setFooter("Lowest online Price: $12.99. Tap to show");
        cardPresenter.addImage(getContext(),R.drawable.blue_shirt);
       // Intent intent2 = new Intent(Intent.ACTION_VIEW);
       // intent2.setData(Uri.parse(String.format(SEARCH_URL, codeValue)));
        
        //cardPresenter.setPendingIntent(createPendingIntent(getContext(), intent));
        //System.out.println(cardPresenters.indexOf(cardPresenter));
        //Log.d(TAG, Integer.toString(cardPresenters.indexOf(cardPresenter)));
        cardPresenters.add(cardPresenter);
      //END CARD #3
        
        
     // CARD #4
        cardPresenter = new CardPresenter();
        cardPresenter.setText("Share").setFooter("Buy or not to buy? Alfani fitted blue");
        cardPresenter.addImage(getContext(),R.drawable.facebook);
        //intent = new Intent(Intent.ACTION_VIEW);
        //intent.setData(Uri.parse(String.format(SEARCH_URL, codeValue)));
        //cardPresenter.setPendingIntent(createPendingIntent(getContext(), intent));

        cardPresenters.add(cardPresenter);
        //END CARD #4
        
        
        return cardPresenters;
    }
    
}
