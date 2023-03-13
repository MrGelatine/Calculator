package mmcs.assignment3_calculator.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField

class CalculatorViewModel: BaseObservable(), Calculator {
    @get:Bindable
    @set:Bindable
    public override  var display = ObservableField<String>("")

    var cur_f_numb = ""
    var cur_s_numb = ""
    var cur_op: Operation? = null
    override public fun addDigit(dig: Int) {
        if(cur_op == null){
            cur_f_numb += dig
        }else{
            cur_s_numb += dig
        }
        display.set(display.get() + dig.toString())
    }
    override public fun addPoint() {
        if(cur_op == null){
            cur_f_numb += '.'
        }else{
            cur_s_numb += '.'
        }
        display.set(display.get() + '.')
    }

    override fun addOperation(op: Operation) {
        if(cur_op != null)
        {
            this.compute()
        }
        cur_op = op
        when(cur_op){
            Operation.ADD -> display.set(display.get() + "+")
            Operation.MUL -> display.set(display.get() + "*")
            Operation.SUB -> display.set(display.get() + "-")
            Operation.DIV -> display.set(display.get() + "/")
        }
    }

    override fun compute() {
        if(cur_s_numb == "")
        {
            return
        }
        when(cur_op){
            Operation.ADD -> {
                cur_f_numb = (cur_f_numb.toFloat() + cur_s_numb.toFloat()).toString()
                cur_op = null
                cur_s_numb = ""
                display.set(cur_f_numb)
            }
            Operation.MUL -> {
                cur_f_numb = (cur_f_numb.toFloat() * cur_s_numb.toFloat()).toString()
                cur_op = null
                cur_s_numb = ""
                display.set(cur_f_numb)
            }
            Operation.SUB -> {
                cur_f_numb = (cur_f_numb.toFloat() - cur_s_numb.toFloat()).toString()
                cur_op = null
                cur_s_numb = ""
                display.set(cur_f_numb)
            }
            Operation.DIV -> {
                cur_f_numb = (cur_f_numb.toFloat() / cur_s_numb.toFloat()).toString()
                cur_op = null
                cur_s_numb = ""
                display.set(cur_f_numb)
            }
        }
    }

    override fun clear() {
        if(cur_s_numb != ""){
            cur_s_numb = cur_s_numb.substring(0, cur_s_numb.length-1)
        }else if(cur_op != null){
            cur_op = null
        }else if(cur_f_numb != ""){
            cur_f_numb = cur_f_numb.substring(0, cur_f_numb.length-1)
        }else{
            return
        }
        var res = display.get().toString().substring(0, display.get().toString().length-1)
        display.set(res)
    }

    override fun reset() {
        TODO("Not yet implemented")
    }

}