<?php

namespace App\Http\Controllers;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Str;
use Illuminate\Support\Facades\Hash;

class LoginController extends Controller
{
  public function index()
  {
   $data = User::where('level','=','pelanggan')->get();

   $dataUser = [
    'message' => 'succes',
    'status' => 202,
    'data' => $data
  ];

   return response()->json($dataUser);
  }

  public function register(Request $request){
      $this->validate($request,[
        'idtoko' => '=!0 | numeric | unique:users',
        'username' => 'required | unique:users',
        'email' => 'required | email | unique:users',
        'telp' => 'required | numeric | unique:users',
        'namapanjang' => 'required | regex:/^[a-zA-Z\s]+$/',
        'password' => ['required', 
        'min:8', 
        'regex:/^.*(?=.*[a-zA-Z])(?=.*[0-9]).*$/']
      ]);

      $level = "pelanggan";
      $data = [
        'idtoko' =>  '0',
        'username' => $request->input('username'),
        'email' => $request->input('email'),
        'telp' => $request->input('telp'),
        'namapanjang' => $request->input('namapanjang'),
        'fotoprofil' => "http://192.168.0.157:8000/upload/ff.png",
        'password' => $request->input('password') ,
        'level' => $level,
        'api_token' => '123456',
        'status' => '0',
        'fototoko' => "http://192.168.0.157:8000/upload/ff.png",
      ];

      User::create($data);
      $dataUser = [
        'message' => 'succes',
        'status' => 202,
        'pesan' => 'daftar berhasil',
        'data' => $data
      ];

      return response()->json($dataUser);
    }

    public function login(Request $request){
      $username = $request->input('username');
      $password = $request->input('password');

      $user = User::where(['username' => $username, 'password' => $password])->first();

      $level = "pelanggan";

      if (isset($user)) {
          if ($password && $username) {
            if ($user->level === $level) {
                // $user->update([
                //     'api_token' => $token
                // ]);
                return response()->json([
                  'message' => 'succes',
                  'status' => 202,
                  'pesan' => 'login berhasil',
                  'data' => $user
                ]);
            } else{
              return response()->json([
               'message' => 'succes',
               'status' => 202,
               'pesan' => 'login gagal',
               'data' => ''
               ]);
            }  
          }else{
           return response()->json([
            'message' => 'succes',
            'status' => 202,
            'pesan' => 'login gagal',
            'data' => ''
            ]);
         }
        }else{
        return response()->json([
          'message' => 'succes',
               'status' => 202,
               'pesan' => 'login gagal',
               'data' => ''
       ]);
    }
    $data = DB::table('users')
       ->join('menus','menus.idtoko','=','users.idtoko')
       ->select('users.*','menus.produk')
       ->where('id','=',$user->id)
      
       ->get();
  }

    public function update(Request $request, $id){
        //

      $user =  User::where('id',$id)->update($request->all());
        if ($user) {
            return response()->json([
                'pesan' => "Data sudah di ubah !"
            ]);
           }
    }
}
