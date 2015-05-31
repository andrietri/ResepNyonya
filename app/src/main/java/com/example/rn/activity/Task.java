package com.example.rn.activity;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

/**
 * Created by andrie on 19/05/15.
 */
public class Task extends AsyncTask<String, Integer, Integer> {

    public interface TaskFinishedListener {
        void onTaskFinished(); //menambah parameter finished untuk mencegah
                                //task di ulang kembali

        //progress bar berjalan ketika ada sesuatu yang hendak di update
        //dibelakang layar
    }

        private final ProgressBar progressBar;
        //listener untuk mendeteksi proses telah berakhir

        private final TaskFinishedListener finishedListener;

        public Task(ProgressBar progressBar, TaskFinishedListener finishedListener){
            this.progressBar = progressBar;
            this.finishedListener = finishedListener;
        }

        @Override
        protected Integer doInBackground(String... params){
            Log.i("Tutorial", "String task with url: "+params[0]);
            if(resourceDontAlreadyExist()){
                downloadResources();
            }
            //memungkinkan untuk kembali padapermintaan yang tereksekusi
            return 1234;
        }

        private boolean resourceDontAlreadyExist(){
            //melakukan permintaan pada app internal utk melihat apakah
            //progress sudah complete atau belum

            //memungkinkan yang telah dicek disimpan pada shared preference
            //untuk kecepatan load jika sewaktu-waktu aplikasi dijalankan kembali

            return true;
        }

        private void downloadResources(){
            //meniru beberapa proses loading
            int count = 10;
            for (int i = 0; i < count; i++){

                //update progress sebanyak x
                int progress = (int) ((i / (float)count)*100);
                publishProgress(progress);

                //lama loading di lakukan
                try { Thread.sleep(250); } catch (InterruptedException ignore) {}
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values){
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            //pemberitahuan progress bar selesai
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            finishedListener.onTaskFinished();
        }



}
