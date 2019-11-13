package com.example.dnd_ar_simulator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var arrayView : Array<View>

    lateinit var chairRenderable: ModelRenderable
    lateinit var tableRenderable: ModelRenderable
    lateinit var chestRenderable: ModelRenderable
    lateinit var dungeonwallRenderable: ModelRenderable
    lateinit var reaperRenderable: ModelRenderable
    lateinit var werewolfRenderable: ModelRenderable
    lateinit var graveRenderable: ModelRenderable
    lateinit var hauntedhouseRenderable: ModelRenderable
    lateinit var spiderRenderable: ModelRenderable
    lateinit var scarytreeRenderable: ModelRenderable
    lateinit var pumpkinRenderable: ModelRenderable

    internal var selected = 1

    lateinit var arFragment:ArFragment


    private fun mySetBackground(id: Int) {
        for(i in arrayView.indices)
        {
            if(arrayView[i].id==id)
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"))
            else
                arrayView[i].setBackgroundColor(Color.TRANSPARENT)
        }
    }
    override fun onClick(view: View?) {
        if (view!!.id == R.id.chair)
        {
            selected = 1
            mySetBackground(view!!.id)
        }
        if (view!!.id == R.id.table)
        {
            selected = 2
            mySetBackground(view!!.id)
        }
        if (view!!.id == R.id.chest)
        {
            selected = 3
            mySetBackground(view!!.id)
        }
        if (view!!.id == R.id.dungeonwall)
        {
            selected = 4
            mySetBackground(view!!.id)
        }
        if (view!!.id == R.id.reaper)
        {
            selected = 5
            mySetBackground(view!!.id)
        }
        if (view!!.id == R.id.werewolf)
        {
            selected = 6
            mySetBackground(view!!.id)
        }
        if (view!!.id == R.id.grave)
        {
            selected = 7
            mySetBackground(view!!.id)
        }
        if (view!!.id == R.id.hauntedhouse)
        {
            selected = 8
            mySetBackground(view!!.id)
        }
        if (view!!.id == R.id.spider)
        {
            selected = 9
            mySetBackground(view!!.id)
        }
        if (view!!.id == R.id.scarytree)
        {
            selected = 10
            mySetBackground(view!!.id)
        }
        if (view!!.id == R.id.pumpkin)
        {
            selected = 11
            mySetBackground(view!!.id)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupArray()
        setupClickListener()
        setupModel()

        arFragment = supportFragmentManager
            .findFragmentById(R.id.sceneform_fragment) as ArFragment
        arFragment.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            val anchor=hitResult.createAnchor()
            val anchorNode = AnchorNode(anchor)
            anchorNode.setParent(arFragment.arSceneView.scene)

            createModel(anchorNode,selected)

        }
    }

    private fun createModel(anchorNode: AnchorNode, selected: Int) {
        if (selected == 1)
        {
            val chair = TransformableNode(arFragment.transformationSystem)
            chair.setParent(anchorNode)
            chair.renderable = chairRenderable
            chair.select()
        }
        if (selected == 2)
        {
            val table = TransformableNode(arFragment.transformationSystem)
            table.setParent(anchorNode)
            table.renderable = tableRenderable
            table.select()
        }
        if (selected == 3)
        {
            val chest = TransformableNode(arFragment.transformationSystem)
            chest.setParent(anchorNode)
            chest.renderable = chestRenderable
            chest.select()
        }
        if (selected == 4)
        {
            val dungeonwall = TransformableNode(arFragment.transformationSystem)
            dungeonwall.setParent(anchorNode)
            dungeonwall.renderable = dungeonwallRenderable
            dungeonwall.select()
        }
        if (selected == 5)
        {
            val reaper = TransformableNode(arFragment.transformationSystem)
            reaper.setParent(anchorNode)
            reaper.renderable = reaperRenderable
            reaper.select()
        }
        if (selected == 6)
        {
            val werewolf = TransformableNode(arFragment.transformationSystem)
            werewolf.setParent(anchorNode)
            werewolf.renderable = werewolfRenderable
            werewolf.select()
        }
        if (selected == 7)
        {
            val grave = TransformableNode(arFragment.transformationSystem)
            grave.setParent(anchorNode)
            grave.renderable = graveRenderable
            grave.select()
        }
        if (selected == 8)
        {
            val hauntedhouse = TransformableNode(arFragment.transformationSystem)
            hauntedhouse.setParent(anchorNode)
            hauntedhouse.renderable = hauntedhouseRenderable
            hauntedhouse.select()
        }
        if (selected == 9)
        {
            val spider = TransformableNode(arFragment.transformationSystem)
            spider.setParent(anchorNode)
            spider.renderable = spiderRenderable
            spider.select()
        }
        if (selected == 10)
        {
            val scarytree = TransformableNode(arFragment.transformationSystem)
            scarytree.setParent(anchorNode)
            scarytree.renderable = scarytreeRenderable
            scarytree.select()
        }
        if (selected == 11)
        {
            val pumpkin = TransformableNode(arFragment.transformationSystem)
            pumpkin.setParent(anchorNode)
            pumpkin.renderable = pumpkinRenderable
            pumpkin.select()
        }
    }

    private fun setupModel() {
        ModelRenderable.builder()
            .setSource(this,R.raw.chair)
            .build()
            .thenAccept{ modelRenderable -> chairRenderable = modelRenderable  }
            .exceptionally { throwable ->
                Toast.makeText(this@MainActivity,"Unable to load Model",Toast.LENGTH_SHORT).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this,R.raw.table)
            .build()
            .thenAccept{ modelRenderable -> tableRenderable = modelRenderable  }
            .exceptionally { throwable ->
                Toast.makeText(this@MainActivity,"Unable to load Model",Toast.LENGTH_SHORT).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this,R.raw.chest)
            .build()
            .thenAccept{ modelRenderable -> chestRenderable = modelRenderable  }
            .exceptionally { throwable ->
                Toast.makeText(this@MainActivity,"Unable to load Model",Toast.LENGTH_SHORT).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this,R.raw.dungeonwall)
            .build()
            .thenAccept{ modelRenderable -> dungeonwallRenderable = modelRenderable  }
            .exceptionally { throwable ->
                Toast.makeText(this@MainActivity,"Unable to load Model",Toast.LENGTH_SHORT).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this,R.raw.reaper)
            .build()
            .thenAccept{ modelRenderable -> reaperRenderable = modelRenderable  }
            .exceptionally { throwable ->
                Toast.makeText(this@MainActivity,"Unable to load Model",Toast.LENGTH_SHORT).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this,R.raw.werewolf)
            .build()
            .thenAccept{ modelRenderable -> werewolfRenderable = modelRenderable  }
            .exceptionally { throwable ->
                Toast.makeText(this@MainActivity,"Unable to load Model",Toast.LENGTH_SHORT).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this,R.raw.grave)
            .build()
            .thenAccept{ modelRenderable -> graveRenderable = modelRenderable  }
            .exceptionally { throwable ->
                Toast.makeText(this@MainActivity,"Unable to load Model",Toast.LENGTH_SHORT).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this,R.raw.hauntedhouse)
            .build()
            .thenAccept{ modelRenderable -> hauntedhouseRenderable = modelRenderable  }
            .exceptionally { throwable ->
                Toast.makeText(this@MainActivity,"Unable to load Model",Toast.LENGTH_SHORT).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this,R.raw.spider)
            .build()
            .thenAccept{ modelRenderable -> spiderRenderable = modelRenderable  }
            .exceptionally { throwable ->
                Toast.makeText(this@MainActivity,"Unable to load Model",Toast.LENGTH_SHORT).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this,R.raw.scarytree)
            .build()
            .thenAccept{ modelRenderable -> scarytreeRenderable = modelRenderable  }
            .exceptionally { throwable ->
                Toast.makeText(this@MainActivity,"Unable to load Model",Toast.LENGTH_SHORT).show()
                null
            }
        ModelRenderable.builder()
            .setSource(this,R.raw.pumpkin)
            .build()
            .thenAccept{ modelRenderable -> pumpkinRenderable = modelRenderable  }
            .exceptionally { throwable ->
                Toast.makeText(this@MainActivity,"Unable to load Model",Toast.LENGTH_SHORT).show()
                null
            }



    }
    private fun setupClickListener() {
        for( i in arrayView.indices)
        {
            arrayView[i].setOnClickListener(this)
        }
    }
    private fun setupArray() {
        arrayView = arrayOf(
            chair,
            table,
            chest,
            dungeonwall,
            reaper,
            werewolf,
            grave,
            hauntedhouse,
            spider,
            scarytree,
            pumpkin
        )
    }
}