package com.example.schola.Model

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.schola.R

class SubjectActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject)

        // Initialize WebView
        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true

        // Map ImageButtons to Google Drive links
        val links = mapOf(
            R.id.subject_swe to "https://classroom.google.com/c/NjU2NzQ4NTE3NTA3",
            R.id.subject_swe_lab to "https://drive.google.com/drive/folders/110QtnYcxBOD266dBFwK_e0yUXKL7mg9X",
            R.id.subject_mp to "https://drive.google.com/drive/folders/1ra_F8xp6CrYrnWkascU_mwQLOjuWbNbj",
            R.id.subject_mp_lab to "https://drive.google.com/drive/folders/1Ye-QWfFf3gn0lhrVvCnAMhDSMUqbLgMQ",
            R.id.subject_cmp to "https://drive.google.com/drive/folders/12UlLCJD9ZufF5iF8ymtUmdIRuKs87tSA",
            R.id.subject_cmp_lab to "https://drive.google.com/drive/folders/10yLnizcZPQ7x7wgkwV9kosJxcQ3pkw-H",
            R.id.subject_ca to "https://drive.google.com/drive/folders/1LJXxPY87RTNpkgYBYR4gBNkvms5BSCve",
            R.id.subject_dc to "https://drive.google.com/drive/folders/1UIutaS83UuB2tpTYZ_e-svUr63HoHpkS",
            R.id.subject_me to "https://drive.google.com/drive/folders/1H60TLDRwYK05Xp3bqZVgBU1JB-pzyyHP",
            R.id.subject_sdp to "https://drive.google.com/drive/folders/1FudqQ7OasNvIXmKtOT-YrIBYol3DNGMO"
        )

        // Set up click listeners for ImageButtons
        links.forEach { (buttonId, url) ->
            findViewById<ImageButton>(buttonId).setOnClickListener {
                webView.loadUrl(url)
                webView.visibility = android.view.View.VISIBLE // Show WebView
            }
        }
    }
}
