<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Menu extends Model
{
    //
    protected $fillable = ['idkategori','idtoko','kategori'
    ,'produk','kodeproduk','stok','deksripsi','','gambar','harga'
    ,'namatoko','fototoko','tahunusaha','alamattoko','kecamatan'
    ,'kabupaten','sosmed','whatsapp','email','menu'];
}
