const base = 'http://localhost:8080/v1';

export const environment = {
    metrics: {
        base: `${base}/places/$placeIdentifier/metrics`
    },

    authentication: {
        signUp: `${base}/authentications/credentials`,
        signIn: `${base}/authentications/tokens`,
        refreshToken: `${base}/authentications/refreshed-tokens`,
    },

    places: {
        base: `${base}/places`,
        specificPlace: `${base}/places/$placeIdentifier`,
    },

    catalogs: {
        reminderQuestions: `${base}/catalogs/reminder-questions`
    }
}