# Roundup_Service
Create a roundup Service created by Daryl Boam

# Endpoint
GET: http://localhost:8080/round_up_account

# Headers

Authorization: YOUR CUSTOMER TOKEN 

Accept: application/json

# Body

None

# Response

```json Schema
{
   {
    "roundUpAccount": {
        "accountUid": String,
        "accountType": String,
        "defaultCategory": String,
    },
    "savingsGoal": {
        "transferUid": String,
        "savingsGoalUid": String
    },
    "roundUpTotal": Number,
    "transactions": {
        "feedItems": [
            {
                "roundedAmount": String,
                "sourceAmount": {
                    "currency": String,
                    "minorUnits": String
                },
                "direction": String
            }
        ]
    }
}
```
```json Example
{
    "roundUpAccount": {
        "accountUid": "46ed3893-c20f-49ce-83d3-5759b0de25da",
        "accountType": "PRIMARY",
        "defaultCategory": "94ccf58d-faf3-4062-ba7e-51729c0297e6"
    },
    "savingsGoal": {
        "transferUid": "9b802ebf-62bf-4a56-8be8-0f20cfde5e09",
        "savingsGoalUid": "560d9b4c-ec39-4c7e-9a67-de043554de11"
    },
    "roundUpTotal": 600,
    "transactions": {
        "feedItems": [
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "600"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "600"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "600"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "600"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "600"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "600"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "600"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": "600",
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "568"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "18"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": "9100",
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "9046"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": "9100",
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "9046"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": "2200",
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "2195"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": "4000",
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "3998"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": "2300",
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "2220"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": "3800",
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "3765"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": "400",
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "362"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": "1400",
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "1391"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "2060"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "970"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "50000"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "1844"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "2572"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "2730"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "200000"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "935"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": "3100",
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "3053"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": "400",
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "395"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "2185"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": "1600",
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "1578"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": "3900",
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "3817"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": "600",
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "517"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "3370"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "1248"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": "400",
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "349"
                },
                "direction": "OUT"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "2786"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "50000"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "200000"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "579"
                },
                "direction": "IN"
            },
            {
                "roundedAmount": null,
                "sourceAmount": {
                    "currency": "GBP",
                    "minorUnits": "1407"
                },
                "direction": "IN"
            }
        ]
    }
}
```
