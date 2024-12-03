import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';

import NavBar from '../pages/Navbar';
import Home from '../pages/Home';
import UserPage from '../pages/UserPage';
import AddUserPage from '../pages/AddUserPage';
import UpdateUserPage from '../pages/UpdateUserPage';
import Login from '../pages/Login';
import Payment from '../pages/Payment';

function App() {
  const [token, setToken] = useState(null);

  useEffect(() => {
    // 로컬 스토리지에서 토큰을 불러옵니다.
    const savedToken = localStorage.getItem('authToken');
    if (savedToken) {
      setToken(savedToken);
    }
  }, []);

  // 로그아웃 처리 함수
  const handleLogout = () => {
    localStorage.removeItem('authToken');
    setToken(null);
  };

  return (
      <Router>
        <div>
          {/* NavBar에 token과 handleLogout을 전달 */}
          <NavBar token={token} onLogout={handleLogout} />

          <Routes>
            {/* 홈 페이지 */}
            <Route path="/" element={<Home />} />

            {/* 유저 페이지 */}
            <Route path="/user" element={<UserPage />} />

            {/* 유저 추가 페이지 */}
            <Route path="/user/add" element={<AddUserPage />} />

            {/* 로그인 페이지 */}
            <Route path="/login" element={<Login setToken={setToken} />} />

            {/* 유저 업데이트 페이지 */}
            <Route path="/user/:id" element={<UpdateUserPage />} />

            {/* 결제 페이지 */}
            <Route path="/payment" element={<Payment />} />

            {/* 토큰이 없으면 로그인 페이지로 리디렉션 */}
            <Route
                path="/protected"
                element={token ? <Home /> : <Navigate to="/login" />}
            />
          </Routes>
        </div>
      </Router>
  );
}

export default App;