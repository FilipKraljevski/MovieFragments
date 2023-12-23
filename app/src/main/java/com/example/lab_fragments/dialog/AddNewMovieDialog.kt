package com.example.lab_fragments.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.lab_fragments.R
import java.lang.ClassCastException
import java.lang.IllegalStateException

class AddNewMovieDialog : DialogFragment(){

    interface AddNewMovieDialogListener{

        fun onDialogPositiveClick(
            title: String,
            plot: String,
            director: String,
            actors: String,
            poster: String
        )

        fun onDialogNegativeClick(dialog: DialogFragment)
    }

    lateinit var listener: AddNewMovieDialogListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as AddNewMovieDialogListener
        } catch (e: ClassCastException){
            throw ClassCastException(context.toString() + "must implement UsernameDialogListener")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val inflaterView = inflater.inflate(R.layout.dialog_add_new_movie, null)
            val editTitle: EditText =  inflaterView.findViewById<EditText>(R.id.editTitle)
            val editPlot : EditText = inflaterView.findViewById<EditText>(R.id.editPlot)
            val editDirector : EditText = inflaterView.findViewById<EditText>(R.id.editDirector)
            val editActors : EditText =inflaterView.findViewById<EditText>(R.id.editActors)
            val editPoster : EditText = inflaterView.findViewById<EditText>(R.id.editPoster)
            builder.setView(inflaterView).setPositiveButton(R.string.ok, DialogInterface.OnClickListener{
                    dialog, id -> listener.onDialogPositiveClick(editTitle.text.toString(),
                editPlot.text.toString(), editDirector.text.toString(), editActors.text.toString(), editPoster.text.toString())
            }).setNegativeButton(R.string.cancel, DialogInterface.OnClickListener {
                    dialog, id-> listener.onDialogNegativeClick(this)
            })
            builder.create()
        }?: throw IllegalStateException("Activity cannot be null")
        }
    }