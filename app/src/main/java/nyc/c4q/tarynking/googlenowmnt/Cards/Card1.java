package nyc.c4q.tarynking.googlenowmnt.Cards;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import models.Currency;
import nyc.c4q.tarynking.googlenowmnt.CurrencyApi;
import nyc.c4q.tarynking.googlenowmnt.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nesada on 11/12/2016.
 */
public class Card1 extends RecyclerView.ViewHolder {
    View mView;
    static TextView mTvEuro, mTvCad, mTvGbp, mTvAud, mTvChf;
    Button mBtnRefresh;

    public Card1(ViewGroup parent) {
        super(inflateView(parent));

        mView = itemView;
        mTvEuro = (TextView) mView.findViewById(R.id.tv_euro);
        mTvCad = (TextView) mView.findViewById(R.id.tv_cad);
        mTvGbp = (TextView) mView.findViewById(R.id.tv_gbp);
        mTvAud = (TextView) mView.findViewById(R.id.tv_aud);
        mTvChf = (TextView) mView.findViewById(R.id.tv_chf);
        mBtnRefresh = (Button) mView.findViewById(R.id.btn_refresh);

        mBtnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh();
            }
        });

    }


    public static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.currency, parent, false);

    }

    public static void refresh() {
        CurrencyApi.Factory.getInstance().getCurrency().enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {

                mTvEuro.setText(response.body().getRates().getEUR() + "");
                mTvCad.setText(response.body().getRates().getCAD() + "");
                mTvGbp.setText(response.body().getRates().getGBP() + "");
                mTvAud.setText(response.body().getRates().getAUD() + "");
                mTvChf.setText(response.body().getRates().getCHF() + "");
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Log.e("test", "Failed");
            }
        });

    }

}
