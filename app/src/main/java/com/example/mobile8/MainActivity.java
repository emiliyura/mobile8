package com.example.mobile8;//package com.example.mobile8;
//
//import android.annotation.SuppressLint;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.TextView;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//
//    // Объявление текстового поля
//    private TextView textView;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        // Инициализация текстового поля
//        textView = findViewById(R.id.text_view);
//        // Создание и запуск нового экземпляра класса MyTask
//        new MyTask().execute();
//    }
//
//    @SuppressLint("StaticFieldLeak")
//    private class MyTask extends AsyncTask<Void, Void, Void> {
//
//        // Метод, выполняющийся в фоновом потоке
//        @Override
//        protected Void doInBackground(Void... voids) {
//            // Вызов трех методов, выполняющих различные задачи
//            task1();
//            task2();
//            task3();
//            return null;
//        }
//
//        // Метод, выполняющийся после завершения фонового потока
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            // Установка текста в текстовое поле после выполнения всех задач
//            textView.setText("Все задачи выполнены");
//        }
//    }
//
//    // Метод, выполняющий первую задачу
//    private void task1() {
//        Log.d("Task", "Task 1 started");
//        try {
//            // Приостановка текущего потока на 2 секунды
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Log.d("Task", "Task 1 finished");
//    }
//
//    // Метод, выполняющий вторую задачу
//    private void task2() {
//        Log.d("Task", "Task 2 started");
//        try {
//            // Приостановка текущего потока на 2 секунды
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Log.d("Task", "Task 2 finished");
//    }
//
//    // Метод, выполняющий третью задачу
//    private void task3() {
//        Log.d("Task", "Task 3 started");
//        try {
//            // Приостановка текущего потока на 2 секунды
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Log.d("Task", "Task 3 finished");
//    }
//}

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView result1TextView;
    private TextView result2TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result1TextView = findViewById(R.id.result1TextView);
        result2TextView = findViewById(R.id.result2TextView);

        // Создаем и запускаем первую задачу
        Task1 task1 = new Task1();
        task1.execute();

        // Создаем и запускаем вторую задачу
        Task2 task2 = new Task2();
        task2.execute();
    }

    // Первая задача
    private class Task1 extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            // Здесь выполняем фоновую работу для первой задачи
            try {
                Thread.sleep(3000); // имитация длительной работы
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Первая задача завершена";
        }

        @Override
        protected void onPostExecute(String result) {
            // Выводим результат первой задачи в соответствующий TextView
            result1TextView.setText(result);
        }
    }

    // Вторая задача
    private class Task2 extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            // Здесь выполняем фоновую работу для второй задачи
            try {
                Thread.sleep(2000); // имитация длительной работы
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Вторая задача завершена";
        }

        @Override
        protected void onPostExecute(String result) {
            // Выводим результат второй задачи в соответствующий TextView
            result2TextView.setText(result);
        }
    }
}
