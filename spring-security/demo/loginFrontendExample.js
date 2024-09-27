const BASE_URL = "http://localhost:8080/api/"

const App = () => {
    const [user, setUser] = useState({})

    useEffect(()=>{
        getMe();
    }, [])

    const getMe = () => {
        const bearer = localStorage.getItem("bearer")
        if (bearer=== undefined)
            return
        const endpoint = BASE_URL + "auth/me"
        const body = {}
        const requestOptions = {
            headers: {
                Authorization: bearer
            }
        }
        //axios' order is endpoint, body, options
        axios.post(endpoint, body, requestOptions)
            .then((response)=>{
                setUser(response.data)
            })
            .catch(()=>{
                alert("You have been logged out because your bearer token caused an error")
                setUser({})
            })
    }

    if (Object.keys(user).length===0){
        //If the user object doesnt exist (They are not logged in)
        return(
            <>
                <LoginPage user = {[user, setUser, getMe]} />
            </>
        )
    } else{
        // OTHERWISE USE NORMAL BROWSER ROUTER
        return(
            <>
                <Header/> {/* Only if you have a header */}
            {/* Browser Router stuff goes here */}
                <HomePage  user = {[user, setUser, getMe]}/>
            </>
        )
    }
}

const LoginPage = (props) => {
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [error, setError] = useState("")
    const [user, setUser, getMe] = props.user

    //Will try to log the user in
    const tryLogin = () =>{
        const endpoint = BASE_URL + "auth/login"
        const body = {}
        const requestOptions = {
            auth: {
                username: username,
                password: password
            }
        }
        //axios' order is endpoint, body, options
        axios.post(endpoint, body, requestOptions)
            .then((response)=>{
                const bearer = response.data
                console.log("Bearer: " + bearer)
                //do something with the bearer, for example
                localStorage.setItem("bearer", bearer)
                getMe();
            })
            .catch((e)=>{
                if (response.status===401){
                    setError("Invalid Credentials")
                } else {
                    setError("Something went wrong (Are you connected to the internet)")
                }
            })

    }
    
    
    return (
        <>
            <p style={{color:red}}>{error}</p>
            <input value={username} onChange={(e)=>setUsername(e.target.val)}/>
            <input value={password} onChange={(e)=>setPassword(e.target.val)}/>
            <button onClick = {tryLogin}>Login</button>
        </>
    )
}

const HomePage = (props) => {
    const [user, setUser, getMe] = props.user

    if (user.role==="admin"){
        return(
            <>Some adming page</>
        )
    } else{
        return(
            <>Normal Page</>
        )
    }
}