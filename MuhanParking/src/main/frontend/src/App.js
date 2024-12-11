import React from 'react';
import { BrowserRouter as Router, Route, Routes, useLocation } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import UserInfo from './pages/UserInfo';
import Navbar from './components/nav';
import MainPagsse from './pages/MainPage';
import ParkingAppPage from './pages/ParkingAppPage'
import UserDetail from './pages/UserDetail';
import ParkingIots from './pages/ParkingIotsPage';
import AIPages from './pages/AIPage';
import IoTPage from './pages/IoTPage';
import ParkingModel from './pages/ParkingModel';
import LocationPage from './pages/LocationPage';
import TrafficPage from './pages/TrafficPage';
import ControlPage from './pages/ControlPage';
import AdminEditPage from './pages/AdminEditPage';
import UserEdit from './pages/UserEdit';

const App = () => {
    return (
        <Router> {/* 전체 애플리케이션을 Router로 감쌈 */}
            <ConditionalNavigation>
                <Routes>
                    <Route path="/" element={<LoginPage />} />
                    <Route path="/register" element={<RegisterPage />} />
                    <Route path='/mainPage' element={<MainPagsse />} />
                    <Route path="/users" element={<UserInfo />} />
                    <Route path='/users/hwan' element={<UserDetail />} />
                    <Route path='/users/edit' element={<UserEdit />} />
                    <Route path='/applicants' element={<ParkingAppPage />} />
                    <Route path='/parking-Iots' element={<ParkingIots />} />
                    <Route path='/ai' element={<AIPages />} />
                    <Route path='/ai/parking-model' element={<ParkingModel />} />
                    <Route path='/iot' element={<IoTPage />} />
                    <Route path='/iot/location' element={<LocationPage />} />
                    <Route path='/iot/traffic-stats' element={<TrafficPage />} />
                    <Route path='/iot/control' element={<ControlPage />} />
                    <Route path='/admin/edit' element={<AdminEditPage />} />
                </Routes>
            </ConditionalNavigation>
        </Router>
    );
};

// 조건부 네비게이션 렌더링
const ConditionalNavigation = ({ children }) => {
    const location = useLocation();
    const excludePaths = ['/', '/register']; // 네비게이션 바를 제외할 경로

    return (
        <>
            {!excludePaths.includes(location.pathname) && <Navbar />}
            {children}
        </>
    );
};

export default App;